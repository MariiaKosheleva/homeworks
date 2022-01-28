package ua.kosheleva.hw4;

import java.util.Arrays;

public class Task2_3 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (1 + (int) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(array));
        System.out.println(PrimeNumbers(array) + " prime numbers and " + CompositeNumbers(array) +
                " composite numbers");
    }

    private static int PrimeNumbers(int[] array) {
        int primeCount = 0;
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int j : copiedArray) {
            if (IsPrime(j)) {
                primeCount++;
            }
        }
        return primeCount;
    }

    private static int CompositeNumbers(int[] array) {
        int compositeCount = 0;
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int j : copiedArray) {
            if (IsComposite(j)) {
                compositeCount++;
            }
        }
        return compositeCount;
    }


    private static boolean IsPrime(int number) {
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

    private static boolean IsComposite(int number) {
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

