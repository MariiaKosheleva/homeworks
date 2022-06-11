package ua.kosheleva.hw25.service;

import ua.kosheleva.hw25.dao.CourseDao;
import ua.kosheleva.hw25.model.Course;
import ua.kosheleva.hw25.model.Student;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CourseService {
    private static final Random RANDOM = new Random();
    private final CourseDao courseDao = new CourseDao();

    public void printCoursesFromSpecificRange() {
        courseDao.getAllCoursesFromSpecifiedRange(3, 7).forEach(course -> {
            System.out.println("\nName: " + course.getCourseName() + "\nComplexity: " + course.getComplexity());
        });
    }

    public void setCourse(Student student, int courseCount) {
        Set<Course> courses = new HashSet<>();
        for (int i = 0; i < courseCount; i++) {
            final Course course = new Course("Course - " + RANDOM.nextInt(0, 1000), RANDOM.nextInt(0, 10));
            course.setStudentSet(Collections.singleton(student));
            courses.add(course);
        }
        student.setCourseSet(courses);
    }
}
