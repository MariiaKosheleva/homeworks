package ua.kosheleva.hw2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Input array elements: ");
        Scanner in = new Scanner(System.in);
        double[] arr = new double[3];
        for (int i = 0; i < 3; i++){
            arr[i] = in.nextDouble();
        }
        for (int i = 0; i < 3; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n" + method3(arr));
    }
    public static double method3(double[] array){
        double min = Math.abs(array[0]);
        for(int i = 0; i < array.length; i++){
            min = (Math.abs(array[i]) < min) ? Math.abs(array[i]) : min;
        }
        return min;
    }
}

