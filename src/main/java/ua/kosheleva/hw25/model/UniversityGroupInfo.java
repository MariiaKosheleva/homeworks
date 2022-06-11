package ua.kosheleva.hw25.model;

import java.util.List;

public class UniversityGroupInfo {
    public void printUniversityGroupInfo(List<Object> amountOfStudentsInEachGroup) {
        for (Object o : amountOfStudentsInEachGroup) {
            Object[] row = (Object[]) o;
            System.out.println("\nGroup id: " + row[0] + "\nName: " + row[1] + "\nAmount of students: " + row[2]);
        }
    }
}
