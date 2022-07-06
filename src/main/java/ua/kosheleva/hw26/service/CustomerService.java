package ua.kosheleva.hw26.service;

import ua.kosheleva.hw26.dao.CustomerDao;
import ua.kosheleva.hw26.model.Customer;

import static com.mongodb.client.model.Filters.*;

public class CustomerService {
    private final CustomerDao customerDao;
    private final static Integer LIMIT_AGE = 18;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void runCustomerService() {
        System.out.println("=".repeat(220));
        System.out.println("printAllCustomers");
        printAllCustomers();
        System.out.println("=".repeat(220));
        System.out.println("printAllCustomersInAgeRange");
        printAllCustomersInAgeRange(9, 25);
        System.out.println("=".repeat(220));
        System.out.println("changeCustomersStatus");
        changeCustomersStatus();
        System.out.println("=".repeat(220));
        System.out.println("printAllCustomers");
        printAllCustomers();
        System.out.println("=".repeat(220));
    }

    private void changeCustomersStatus() {
        customerDao.findAllByFilter(Customer.class, lt("age", LIMIT_AGE)).forEach(customer -> {
            customerDao.updateStatus("lowAge");
        });
    }

    private void printAllCustomersInAgeRange(Integer minAge, Integer maxAge) {
        customerDao.findAllByFilter(Customer.class, and(gt("age", minAge), lt("age", maxAge))).forEach(System.out::println);
    }

    private void printAllCustomers() {
        customerDao.findAll().forEach(System.out::println);
    }

}
