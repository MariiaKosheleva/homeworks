package ua.kosheleva.hw25.service;

import ua.kosheleva.hw25.dao.UniversityDao;
import ua.kosheleva.hw25.model.Student;
import ua.kosheleva.hw25.model.University;

import java.util.*;

public class UniversityService {
    private final UniversityDao universityDao = new UniversityDao();
    private final UniversityInfrastructureService infrastructureService = new UniversityInfrastructureService();

    public void setInfrastructureService() {
        infrastructureService.createUniversityInfrastructure();
    }

    public void print() {
        universityDao.getAll().forEach(university -> {
            System.out.println("\nUniversity id: " + university.getId() +
                    "\nUniversity name: " + university.getUniversityName());
            getUniversityGroups(university);
            getCurators(university);
            getStudents(university);
            getCourses(university);

        });
    }

    private void getCourses(University university) {
        System.out.println("\nCourses in " + university.getUniversityName() + " by students in groups: ");
        Optional.ofNullable(university.getUniversityGroups())
                .ifPresent(universityGroups -> universityGroups.forEach(universityGroup -> {
                    System.out.println(universityGroup.getUniversityGroupName() +
                            ": " + universityGroup.getStudents().stream()
                            .map(Student::getCourseSet)
                            .toList());
                }));
    }

    private void getStudents(University university) {
        System.out.println("\nStudents from " + university.getUniversityName() + ": ");
        Optional.ofNullable(university.getUniversityGroups())
                .ifPresent(universityGroups -> universityGroups.forEach(universityGroup -> {
                    System.out.println(universityGroup.getUniversityGroupName() +
                            ": " + universityGroup.getStudents());
                }));
    }

    private void getCurators(University university) {
        System.out.println("\nCurators from " + university.getUniversityName() + ": ");
        Optional.ofNullable(university.getUniversityGroups())
                .ifPresent(universityGroups -> universityGroups.forEach(universityGroup -> {
                    System.out.println(universityGroup.getCurator().getCuratorName());
                }));
    }

    private void getUniversityGroups(University university) {
        System.out.println("\nGroups id and names from " + university.getUniversityName() + ": ");
        Optional.ofNullable(university.getUniversityGroups())
                .ifPresent(universityGroups -> universityGroups.forEach(universityGroup -> {
                    System.out.println(universityGroup.getId() +
                            ", " + universityGroup.getUniversityGroupName());
                }));
    }
}
