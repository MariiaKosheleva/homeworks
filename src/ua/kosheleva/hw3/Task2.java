package ua.kosheleva.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println(wordCount(text));
    }
    private static int wordCount(String text){
        int count = 0;
        text = text.replaceAll("[\\s]{2,}", " ");
        String[] words = text.split(" ");
        count += words.length;
        return count;

    }
}
