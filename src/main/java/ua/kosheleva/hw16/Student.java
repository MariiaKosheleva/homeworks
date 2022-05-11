package ua.kosheleva.hw16;

import lombok.ToString;

@ToString
public class Student {
    private final String name;
    private final String group;
    private int course;
    private final double averageMark;

    public Student(String name, String group, int course, double averageMark) {
        if (course < 1 || course > 6 || averageMark < 1 || averageMark > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.group = group;
        this.course = course;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public int getCourse() {
        return course;
    }

    public void courseUpgrade() {
        this.course++;
    }
}
