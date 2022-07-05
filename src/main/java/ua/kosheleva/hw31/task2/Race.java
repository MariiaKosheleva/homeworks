package ua.kosheleva.hw31.task2;

import java.util.Scanner;

public class Race {
    public static int AMOUNT_OF_HORSES;
    public static int HORSE_TO_BET;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void enterAmountOfHorsesForRace() {
        System.out.println("Enter the amount of horses for race: ");
        AMOUNT_OF_HORSES = SCANNER.nextInt();
    }

    public void chooseHorseToBet() {
        System.out.println("Choose horse to bet (from 1 to " + AMOUNT_OF_HORSES + ")");
        HORSE_TO_BET = SCANNER.nextInt();
        System.out.println("Good luck on the race!");
    }
}
