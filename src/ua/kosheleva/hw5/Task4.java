package ua.kosheleva.hw5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        fillRandomArray(numbers);
        System.out.print(Arrays.toString(deleteElementAndMakeShift(numbers)));
    }

    private static void fillRandomArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);

        }
        System.out.print(Arrays.toString(array));
        System.out.println();
    }

    private static int[] deleteElementAndMakeShift(int[] array) {
        int[] copy = new int[array.length - 1];
        System.out.println("Enter the index of element you want to delete: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        for (int i = 0; i < index; i++) {
            copy[i] = array[i];
        }
        for (int i = index; i < copy.length; i++) {
            copy[i] = array[i + 1];
        }
        return copy;
    }

}

