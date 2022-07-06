package ua.kosheleva.hw30.task2;

import ua.kosheleva.hw30.task2.util.ThreadPrimeNumbersUtil;

public class Main {
    final static ThreadPrimeNumbersUtil threadPrimeNumbersUtil = new ThreadPrimeNumbersUtil();
    public static void main(String[] args) {
        System.out.println("\nTask 2:");
        threadPrimeNumbersUtil.printAmountOfPrimeNumbers();
    }
}
