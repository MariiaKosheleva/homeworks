package ua.kosheleva.module2;

import ua.kosheleva.module2.models.Invoice;
import ua.kosheleva.module2.services.ShopService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        readLimitAndDoActions();
    }

    private static void readLimitAndDoActions() throws IllegalAccessException {
        System.out.println("Input the limit: ");
        final Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            Invoice.setLimit(scanner.nextInt());
            ShopService shopService = new ShopService();
            shopService.getData("Products.csv");
            shopService.getAnalyticalInformation();
        } else {
            System.out.println("Limit value isn't valid!");
        }
        scanner.close();
    }
}