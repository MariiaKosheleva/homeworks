package ua.kosheleva.hw2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number: ");
        int number = in.nextInt();
        method1(number);
    }
    public static void method1(int x){
        if(x % 2 == 0) {
            System.out.println("Number " + x + " is even");
        }else{
            System.out.println("Number " + x + " is odd");
        }
    }
}
