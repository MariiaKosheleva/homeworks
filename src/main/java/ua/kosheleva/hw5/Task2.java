package ua.kosheleva.hw5;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        //для проверки на true
        int[] numbers = {7, 8, 5, 4, 2};
        //для проверки на false
        //int[] numbers = {8, 5 , 4, 6};
        System.out.print(Arrays.toString(numbers));
        System.out.println(checkForDescendingOrder(numbers));
    }

    private static boolean checkForDescendingOrder(int[] array) {
        boolean check = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                check = false;
                break;
            }
        }
        System.out.println();
        return check;
    }
}
