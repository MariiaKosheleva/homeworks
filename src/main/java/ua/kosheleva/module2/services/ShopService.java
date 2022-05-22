package ua.kosheleva.module2.services;

import ua.kosheleva.module2.models.Invoice;
import ua.kosheleva.module2.models.Product;
import ua.kosheleva.module2.utils.AnalyticalData;
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

    public void getAnalyticalInformation(){
        final AnalyticalData analiticalData = new AnalyticalData();
        System.out.println("\nAmount of sold telephones: " + analiticalData.soldProductsByCategories(listOfInvoices, "Telephone"));
        System.out.println("\nAmount of sold television: " + analiticalData.soldProductsByCategories(listOfInvoices, "Television"));
        System.out.println();
        System.out.println("\nCheck with minimal sum: " + analiticalData.getCheckWithMinSum(listOfInvoices));
        System.out.println();
        System.out.println("\nSum of all checks: " + analiticalData.countSumOfAllInvoices(listOfInvoices));
        System.out.println();
        System.out.println("\nChecks with one type products: " + analiticalData.getChecksWithOneProductType(listOfInvoices));
        System.out.println();
        System.out.println("\nChecks with retail type: " + analiticalData.countChecksWithRetailType(listOfInvoices));
        System.out.println();
        System.out.println("\nThree first checks: " + analiticalData.getThreeFirstChecks(listOfInvoices));
        System.out.println();
        System.out.println("\nChecks with low_age type: " + analiticalData.getLowAgeChecks(listOfInvoices));
        System.out.println();
        System.out.println("\nSorted checks: " + analiticalData.getSortedChecks(listOfInvoices));
    }
}
