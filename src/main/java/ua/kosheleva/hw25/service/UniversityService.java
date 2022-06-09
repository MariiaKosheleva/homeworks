package ua.kosheleva.hw25.service;


import ua.kosheleva.hw25.dao.UniversityDao;
import ua.kosheleva.hw25.model.University;
import ua.kosheleva.hw25.model.UniversityGroup;

import java.util.*;

public class UniversityService {
    private final UniversityGroupService universityGroupService = new UniversityGroupService();
    private final StudentService studentService = new StudentService();
    private final CuratorService curatorService = new CuratorService();
    private final UniversityDao universityDao = new UniversityDao();
    private final CourseService courseService = new CourseService();

    private UniversityService step1() {
        return this;
    }

    public void createUniversityInfrastructure() {
        final List<University> universities = createUniversity();

        final University university1 = universities.get(0);
        final UniversityGroup universityGroup1 =
                universityGroupService.createUniversityGroup("universityGroup1", university1);
        final UniversityGroup universityGroup2 =
                universityGroupService.createUniversityGroup("universityGroup2", university1);
        final UniversityGroup universityGroup3 =
                universityGroupService.createUniversityGroup("universityGroup3", university1);

        final Set<UniversityGroup> universityGroups = new HashSet<>();
        universityGroups.add(universityGroup1);
        universityGroups.add(universityGroup2);
        universityGroups.add(universityGroup3);
        university1.setUniversityGroups(universityGroups);

        studentService.addStudents(universityGroup1, 2);
        studentService.addStudents(universityGroup2, 4);

        curatorService.addCurator(universityGroup1);
        curatorService.addCurator(universityGroup2);

        universityGroup1.getStudents().forEach(student -> courseService.setCourse(student, 3));

        for (University university : universities) {
            universityDao.save(university);
        }
    }

    private List<University> createUniversity() {
        final University university1 = new University("university1");
        final University university2 = new University("university2");
        return Arrays.asList(university1, university2);
    }

    public void print() {
        universityDao.getAll().forEach(university -> {
            System.out.println(getFormattedString(university.getId(), university.getUniversityName(),
                    university.getClass().getSimpleName()));
            Optional.ofNullable(university.getUniversityGroups())
                    .ifPresent(universityGroups -> universityGroups.forEach(universityGroup -> {
                        System.out.println(getFormattedString(universityGroup.getId(), universityGroup.getUniversityGroupName(),
                                universityGroup.getClass().getSimpleName()));
                    }));
        });
    }

    private String getFormattedString(String id, String name, String className) {
        return String.format("Class: %s%n ID: %s%n Name: %s%n",
                className, id, name);
    }
}
