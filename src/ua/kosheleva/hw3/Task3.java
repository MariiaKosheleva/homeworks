package ua.kosheleva.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int a = 0, b = 10;
        int secret = a + (int)(Math.random() * b);
        System.out.println("Введите число: ");
        guessNum(secret);
    }
    private static void guessNum(int secret){
        Scanner in = new Scanner(System.in);
        int guess = in.nextInt();
        while (guess > secret){
            System.out.println("Много");
            guess = in.nextInt();
            if(guess == secret){
                break;
            }
        }
        while(guess < secret){
            System.out.println("Мало");
            guess = in.nextInt();
            if(guess == secret){
                break;
            }
        }
        if(guess == secret){
            System.out.println("Вы угадали!");
        }
    }
}
