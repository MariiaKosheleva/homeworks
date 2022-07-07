package ua.kosheleva.hw31.task2;

import java.util.Scanner;

public class Race {
    public static int amountOfHorses;
    public static int horseToBet;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void enterAmountOfHorsesForRace() {
        System.out.println("Enter the amount of horses for race: ");
        while (!SCANNER.hasNextInt()) {
            System.out.println("It's not a number!");
            SCANNER.next();
        }
        amountOfHorses = SCANNER.nextInt();
    }

    public void chooseHorseToBet() {
        System.out.println("Choose horse to bet (from 1 to " + amountOfHorses + ")");
        while (!SCANNER.hasNextInt()) {
            System.out.println("It's not a number!");
            SCANNER.next();
        }
        horseToBet = SCANNER.nextInt();
        System.out.println("Good luck on the race!");
    }
}
