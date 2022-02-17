package ua.kosheleva.hw9;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (1 + (int) (Math.random() * 10));
        }
        System.out.println(Arrays.toString(array));
        int[] resultArray = replacingEvenNumbersWithZeros(array);
    }

    public static int[] replacingEvenNumbersWithZeros(int[] array) {
        int[] copiedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 2 == 0) {
                copiedArray[i] = 0;
            }
        }
        return copiedArray;
    }
}
