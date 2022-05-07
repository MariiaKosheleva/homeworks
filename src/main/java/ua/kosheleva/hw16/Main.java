package ua.kosheleva.hw16;

import java.util.*;

import static ua.kosheleva.hw16.ListMethods.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        fillList(arrayList);
        fillList(linkedList);
        System.out.print("Elapsed time in the arrayList: ");
        elapsedTime(arrayList);
        System.out.print("Elapsed time in the linkedList: ");
        elapsedTime(linkedList);
        System.out.println();

        System.out.println("Task2");
        String inputString = "На дворе трава, на траве дрова, " +
                "Не руби дрова на траве двора.";
        System.out.println(inputString);
        Vocabulary vocabulary = new Vocabulary(inputString);
        System.out.println();
        vocabulary.showVocabulary();
        System.out.println();

        System.out.println("Task3");
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(array));
        printArr(new ArrayIterator<>(array));
        System.out.println();

        System.out.println("Task4");
        List<Student> students = new LinkedList<>();
        students.add(new Student("Mike", "IKM-221", 1, 3));
        students.add(new Student("Mariia", "IKM-220", 2, 5));
        students.add(new Student("Lola", "IKM-219", 3, 2));
        students.add(new Student("Leo", "IKM-219", 3, 5));
        students.add(new Student("Eugene", "IKM-218", 4, 3));
        students.add(new Student("Ann", "IKM-217", 5, 4));
        students.add(new Student("Daniel", "IKM-220", 2, 5));
        students.add(new Student("Yun", "IKM-216", 6, 3));
        System.out.println("Initial list:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
        System.out.println("2nd course:");
        printStudents(students, 2);
        System.out.println("3rd course:");
        printStudents(students, 3);
        System.out.println();
        ActionsWithStudents(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    private static void printArr(ArrayIterator<Object> arr) {
        while (arr.hasNext()) {
            System.out.println(arr.next());
        }
    }

    private static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    private static void ActionsWithStudents(List<Student> students) {
        students.removeIf(student -> student.getAverageMark() < 3);
        for (Student student : students) {
            if (student.getAverageMark() >= 3) {
                student.courseUpgrade();
            }
        }
        students.removeIf(student -> student.getCourse() > 6);
    }
}


