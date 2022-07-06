package ua.kosheleva.hw30.task1;

import ua.kosheleva.hw30.task1.util.ThreadGreeterUtil;

public class Main {
    final static ThreadGreeterUtil threadGreeterUtil = new ThreadGreeterUtil();
    public static void main(String[] args) {
        System.out.println("Task 1:");
        threadGreeterUtil.printThread();
    }
}