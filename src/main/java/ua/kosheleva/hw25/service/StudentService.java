package ua.kosheleva.hw25.service;

import ua.kosheleva.hw25.dao.StudentDao;
import ua.kosheleva.hw25.model.Student;
import ua.kosheleva.hw25.model.StudentInfo;
import ua.kosheleva.hw25.model.UniversityGroup;

import java.util.*;

public class StudentService {
    private static final Random RANDOM = new Random();
    private final StudentDao studentDao = new StudentDao();
    private final StudentInfo studentInfo = new StudentInfo();

    public void printAllInfoAboutCertainStudent(Integer index) {
        studentInfo.printStudentInfo(studentDao.getAllInfoAboutCertainStudent(studentDao.getAll().get(index).getId()));
    }

    public void addStudents(UniversityGroup group, int count) {
        Set<Student> studentSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            Student student = new Student("Student-" + RANDOM.nextInt(0, 1000));
            student.setGroupSet(Collections.singleton(group));
            studentSet.add(student);
        }
        group.setStudents(studentSet);
    }
}
