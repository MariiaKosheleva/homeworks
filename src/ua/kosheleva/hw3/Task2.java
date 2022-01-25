package ua.kosheleva.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        WordCount(text);
    }
    private static void WordCount(String text){
        int count = 0;
        text = text.replaceAll("[\\s]{2,}", " ");
        String[] words = text.split(" ");
        count += words.length;
        if(count == 1){
            System.out.println(count + " word");
        }else {
            System.out.println(count + " words");
        }
    }
}
