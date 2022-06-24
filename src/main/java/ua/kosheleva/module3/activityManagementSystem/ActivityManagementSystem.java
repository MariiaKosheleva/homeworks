package ua.kosheleva.module3.activityManagementSystem;

import ua.kosheleva.module3.dao.*;

import java.util.*;

public class ActivityManagementSystem {
    private final TeacherDao teacherDao = new TeacherDao();
    private final GroupDao groupDao = new GroupDao();
    private final SubjectDao subjectDao = new SubjectDao();
    private final UndergraduateDao undergraduateDao = new UndergraduateDao();

    public void greeter() {
        System.out.println("Welcome to Activity Management System of your university!\n" +
                "Choose which information you want to see:");
        System.out.println("""
                \nInformation which you can find there:
                                
                - Find groups by typed name
                - Get amount of students in each group
                - Get average mark value in each group
                - Find the teacher by firstname and lastname
                - Get information about subjects with the best and worth academical performance
                - Get information about students with average mark value greater than input limit
                - Exit from menu""");
        System.out.println("\nInput 1 to start program work:");
    }

    public void launchActivityManagementSystem() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid argument!");
        }
        while (inputNumber != 0) {
            System.out.println("""
                    \n1 - Find groups by typed name
                    2 - Get amount of students in each group
                    3 - Get average mark value in each group
                    4 - Find the teacher by firstname and lastname
                    5 - Get information about subjects with the best and worth academical performance
                    6 - Get information about students with average mark value greater than input limit
                    0 - Exit from menu""");
            inputNumber = Integer.parseInt(scanner.next());
            if (inputNumber == 1) {
                System.out.println("Groups by typed name" + "\nInput typed name: ");
                String typedName = scanner.next();
                printGroupsByTypedName(typedName);
            } else if (inputNumber == 2) {
                System.out.println("Amount of students in each group");
                printAmountOfStudentsGroups();
            } else if (inputNumber == 3) {
                System.out.println("Average mark value in each group");
                printAverageMarkValueForGroups();
            } else if (inputNumber == 4) {
                System.out.println("The teacher by firstname and lastname" + "\nInput firstName and lastName: ");
                String firstName = scanner.next();
                String lastName = scanner.next();
                printTeacherByFirstNameLastName(firstName, lastName);
            } else if (inputNumber == 5) {
                System.out.println("Information about subjects with the best and worth academical performance");
                printSubjectMinMaxAcademicPerformance();
            } else if (inputNumber == 6) {
                System.out.println("Information about students with average mark value greater than input limit" +
                        "\nInput the limit (double format): ");
                try {
                    printAverageMarkValueGreaterThanLimitForUndergraduates(Double.parseDouble(scanner.next()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid argument!");
                }
            } else if (inputNumber == 0) {
                System.out.println("Bye! We hope that you has found information which you wanted!");
            }
        }
    }

    private void printAverageMarkValueGreaterThanLimitForUndergraduates(Double limit) {
        undergraduateDao.printAverageMarkValueGreaterThanLimitForEachUndergraduate(undergraduateDao.getAverageMarkValueGreaterThanLimitForUndergraduates(limit));
    }

    private void printSubjectMinMaxAcademicPerformance() {
        subjectDao.printSubjectMaxAcademicPerformance(subjectDao.getMaxAcademicPerformance(), subjectDao.getSubjectInfoByMaxAcademicPerformance(),
                subjectDao.getMinAcademicPerformance(), subjectDao.getSubjectInfoByMinAcademicPerformance());
    }

    private void printAverageMarkValueForGroups() {
        groupDao.printAverageMarkValueForEachGroups(groupDao.getAverageMarkValueForGroups());
    }

    private void printAmountOfStudentsGroups() {
        groupDao.printAmountOfStudentsForEachGroup(groupDao.getAmountOfStudentsInEachGroup());
    }

    private void printTeacherByFirstNameLastName(String firstName, String lastName) {
        teacherDao.printTeacherInfo(teacherDao.findTeacherByFirstNameLastName(firstName, lastName));
    }

    private void printGroupsByTypedName(String typedName) {
        groupDao.printGroupsInfo(groupDao.findGroupsByFewSighs(typedName));
    }
}
