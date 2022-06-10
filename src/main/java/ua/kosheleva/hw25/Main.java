package ua.kosheleva.hw25;

import ua.kosheleva.hw25.config.HibernateFactoryUtil;
import ua.kosheleva.hw25.service.*;

public class Main {
    private static final CourseService courseService = new CourseService();
    private static final CuratorService curatorService = new CuratorService();
    private static final UniversityGroupService universityGroupService = new UniversityGroupService();
    private static final StudentService studentService = new StudentService();
    private static final UniversityService universityService = new UniversityService();

    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        universityService.setInfrastructureService();
        courseService.printCoursesFromSpecificRange();
        curatorService.printAllTeachersBornBeforeXDateAndWithMoreThanYWorkExperience();
        studentService.printAllInfoAboutCertainStudent(0);
        universityGroupService.printAmountOfStudentsInEachGroup();
        universityService.print();
    }
}
