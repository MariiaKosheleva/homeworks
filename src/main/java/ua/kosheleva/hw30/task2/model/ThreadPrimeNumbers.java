package ua.kosheleva.hw30.task2.model;

import java.util.List;

public class ThreadPrimeNumbers extends Thread {
    private final List<Integer> numbers;
    private int primesCount;

    public ThreadPrimeNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        primesCount = 0;
    }

    public int getPrimes() {
        return primesCount;
    }

    public void run() {
        for (int number : numbers) {
            if (checkPrimeNumbers(number)) {
                primesCount++;
            }
        }
        System.out.println("Part of prime numbers: " + primesCount);
    }

    private boolean checkPrimeNumbers(int inputNumber) {
        if (inputNumber <= 1) {
            return false;
        }
        for (int i = 2; i <= inputNumber / 2; i++) {
            if ((inputNumber % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
