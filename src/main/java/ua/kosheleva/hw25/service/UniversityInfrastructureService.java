package ua.kosheleva.hw25.service;

import ua.kosheleva.hw25.dao.UniversityDao;
import ua.kosheleva.hw25.model.University;
import ua.kosheleva.hw25.model.UniversityGroup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniversityInfrastructureService {
    private final UniversityGroupService universityGroupService = new UniversityGroupService();
    private final StudentService studentService = new StudentService();
    private final CuratorService curatorService = new CuratorService();
    private final UniversityDao universityDao = new UniversityDao();
    private final CourseService courseService = new CourseService();

    public void createUniversityInfrastructure() {
        final List<University> universities = createUniversity();

        final University university1 = universities.get(0);
        final UniversityGroup universityGroup1 =
                universityGroupService.createUniversityGroup("universityGroup1", university1);
        final UniversityGroup universityGroup2 =
                universityGroupService.createUniversityGroup("universityGroup2", university1);

        final Set<UniversityGroup> universityGroups = new HashSet<>();
        universityGroups.add(universityGroup1);
        universityGroups.add(universityGroup2);

        university1.setUniversityGroups(universityGroups);

        studentService.addStudents(universityGroup1, 2);
        studentService.addStudents(universityGroup2, 3);

        curatorService.addCurator(universityGroup1);
        curatorService.addCurator(universityGroup2);

        universityGroup1.getStudents().forEach(student -> courseService.setCourse(student, 1));
        universityGroup2.getStudents().forEach(student -> courseService.setCourse(student, 1));

        for (University university : universities) {
            universityDao.save(university);
        }
    }

    private List<University> createUniversity() {
        final University university1 = new University("university1");
        return List.of(university1);
    }
}
