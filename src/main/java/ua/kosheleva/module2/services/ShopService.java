package ua.kosheleva.module2.services;

import ua.kosheleva.module2.models.Invoice;
import ua.kosheleva.module2.models.Product;
import ua.kosheleva.module2.utils.FileUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class ShopService {

    private static final ArrayList<Invoice> listOfInvoices = new ArrayList<>();

    public void getData(String fileName){
        FileUtils fileUtils = new FileUtils();
        ArrayList<Product> products = (ArrayList<Product>) fileUtils.readCsvFile(fileName);
        createListOfInvoices(products);
        fileUtils.logOrdersInfo(listOfInvoices);
    }

    private void createListOfInvoices(ArrayList<Product> listOfLoadedProducts) {
        try {
            for (int i = 0; i < 15; i++) {
                listOfInvoices.add(createInvoice(listOfLoadedProducts));
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static Invoice createInvoice(ArrayList<Product> products) {
        Random random = new Random();
        int amountOfProducts = random.nextInt(5) + 1;
        Product[] productsArray = new Product[amountOfProducts];
        for (int i = 0; i < amountOfProducts; i++) {
            productsArray[i] = products.get(random.nextInt(products.size()));
        }
        Invoice invoice = new Invoice(productsArray, PersonService.createCustomer(), new Date());
        invoice.setType();
        return invoice;
    }
}
