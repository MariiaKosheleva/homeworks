package ua.kosheleva.hw5;


import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input array size: ");
        int size = in.nextInt();
        int[][] numbers = new int[size][size];
        fillRandomArray(numbers);
        System.out.println();
        swapColumnsAndRows(numbers);
    }

    private static void fillRandomArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] copyArray(int[][] array) {
        int[][] copied = new int[array[0].length][array.length];
        for (int i = 0; i < copied.length; i++) {
            for (int j = 0; j < copied[i].length; j++) {
                copied[i][j] = array[i][j];
            }
        }
        return copied;
    }

    private static int[][] swapColumnsAndRows(int[][] array) {
        int[][] arraySwapped = copyArray(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arraySwapped[j][i] = array[i][j];
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(arraySwapped[i][j] + " ");
            }
            System.out.println();
        }
        return arraySwapped;
    }
}
