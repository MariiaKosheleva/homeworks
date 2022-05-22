package ua.kosheleva.module2;

import org.apache.commons.lang3.RandomStringUtils;
import ua.kosheleva.module2.models.Invoice;
import ua.kosheleva.module2.services.PersonService;
import ua.kosheleva.module2.services.ShopService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        shopService.getData("Products.csv");

    }

    private static void readLimit(){
        System.out.println("Input the limit: ");
        Scanner readLine = new Scanner(System.in);
        double limit = readLine.nextDouble();
        readLine.close();
    }
}
