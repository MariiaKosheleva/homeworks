package ua.kosheleva.hw4;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = (1 + (int) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(array));
        System.out.printf("Arithmetic mean: " + "%.2f", arithmeticMean(array));
        System.out.printf("\nGeometric mean:  " + "%.2f", geometricMean(array));
    }

    private static double arithmeticMean(int[] array) {
        double arithmetic = 0;
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int j : copiedArray) {
            arithmetic += j;
        }
        arithmetic /= copiedArray.length;
        return arithmetic;
    }

    private static double geometricMean(int[] array) {
        int[] copiedArray = Arrays.copyOf(array, array.length);
        double geometric = 1;
        for (int j : copiedArray) {
            geometric *= j;
        }
        geometric = Math.pow(geometric, 1.0 / copiedArray.length);
        return geometric;
    }
}
