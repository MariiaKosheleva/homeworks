package ua.kosheleva.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        IsPalindrome(text);
    }
    private static void IsPalindrome(String text){
        text = text.toLowerCase();
        text = text.replaceAll("[\\s]", " ");
        String reversedString = new StringBuffer(text).reverse().toString();
        if(text.equals(reversedString)){
            System.out.println("Is palindrome");
        }else{
            System.out.println("Isn't palindrome");
        }
    }
}
