package ua.kosheleva.hw25.model;

import java.util.List;

public class StudentInfo {
    public void printStudentInfo(List<Object> allInfoAboutCertainStudent) {
        for (Object o : allInfoAboutCertainStudent) {
            Object[] row = (Object[]) o;
            System.out.println("\nStudent id: " + row[0] + "\nName: " + row[1] + "\nGroup: " + row[2] +
                    "\nCurator: " + row[3] + "\nUniversity: " + row[4]);
        }
    }
}
