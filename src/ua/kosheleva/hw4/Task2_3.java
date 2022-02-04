package ua.kosheleva.hw4;

import java.util.Arrays;

public class Task2_3 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (1 + (int) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(array));
        System.out.println(primeNumbers(array) + " prime numbers and " + compositeNumbers(array) +
                " composite numbers");
    }

    private static int primeNumbers(int[] array) {
        int primeCount = 0;
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int j : copiedArray) {
            if (isPrime(j)) {
                primeCount++;
            }
        }
        return primeCount;
    }

    private static int compositeNumbers(int[] array) {
        int compositeCount = 0;
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int j : copiedArray) {
            if (isComposite(j)) {
                compositeCount++;
            }
        }
        return compositeCount;
    }


    private static boolean isPrime(int number) {
        boolean primeNum = true;
        if (number != 1) {
            for (int i = 2; i < number; i++) {
                if (i != number && number % i == 0) {
                    primeNum = false;
                    break;
                }
            }
        } else {
            primeNum = false;
        }
        return primeNum;
    }

    private static boolean isComposite(int number) {
        boolean compositeNum = false;
        if (number != 1) {
            for (int i = 2; i < number; i++) {
                if (i != number && number % i == 0) {
                    compositeNum = true;
                    break;
                }
            }
        }
        return compositeNum;
    }
}

