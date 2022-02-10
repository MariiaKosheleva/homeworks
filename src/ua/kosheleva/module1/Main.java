package ua.kosheleva.module1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input array size: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        arraySizeCheck(size);
        int[] numbers = new int[size];

        fillRandomArray(numbers);
        int[] sortedArray = arraySorting(numbers);
        System.out.println(Arrays.toString(sortedArray));
        System.out.println();
        System.out.println("Every 3rd element in the cube: ");
        System.out.println(Arrays.toString(raiseToCube(sortedArray)));
        System.out.println();

        Lock lock = new Lock(new int[]{1, 2, 3});
        lock.print();
        lock.getArr()[0] = 10;
        lock.print();

    }

    public static void arraySizeCheck(int size) {
        if (size < 10) {
            throw new RuntimeException("Invalid length value (you should enter 10 or more)");
        }
    }

    public static void fillRandomArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (-100 + (Math.random() * (100 - (-100))));
        }
        System.out.println(Arrays.toString(array));
    }

    public static int[] arraySorting(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        System.out.println("\nSelect sorting number (1 - descending or 2 - ascending): ");
        Scanner in = new Scanner(System.in);
        int sortingMethod = in.nextInt();
        switch (sortingMethod) {
            case 1 -> {
                for (int i = 0; i < copy.length - 1; i++) {
                    for (int j = copy.length - 1; j > i; j--) {
                        if (copy[j - 1] < copy[j]) {
                            int tmp = copy[j - 1];
                            copy[j - 1] = copy[j];
                            copy[j] = tmp;
                        }
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < copy.length - 1; i++) {
                    for (int j = copy.length - 1; j > i; j--) {
                        if (copy[j - 1] > copy[j]) {
                            int tmp = copy[j - 1];
                            copy[j - 1] = copy[j];
                            copy[j] = tmp;
                        }
                    }
                }
            }
        }
        return copy;
    }

    public static int[] raiseToCube(int[] array) {
        for (int i = 0; i < array.length; i += 3) {
            array[i] = array[i] * array[i] * array[i];
        }
        return array;
    }
}

