package ua.kosheleva.module2.services;

import org.apache.commons.lang3.RandomStringUtils;
import ua.kosheleva.module2.models.Customer;

import java.util.Locale;
import java.util.Random;

public class PersonService {
    public static Customer createCustomer() {
        Random random = new Random();
        String email = RandomStringUtils.randomAlphanumeric(8, 16).toLowerCase(Locale.ROOT) + "@gmail.com";
        return new Customer(Math.abs(random.nextLong()), email, random.nextInt(15, 51));
    }
}
