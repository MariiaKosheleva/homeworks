package ua.kosheleva.module2.services;

import ua.kosheleva.module2.models.Invoice;
import ua.kosheleva.module2.models.Product;
import ua.kosheleva.module2.utils.AnalyticalData;
import ua.kosheleva.module2.utils.FileUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class ShopService {

    private static final ArrayList<Invoice> listOfInvoices = new ArrayList<>();

    public void getData(String fileName) {
        FileUtils fileUtils = new FileUtils();
        List<Product> products = fileUtils.readCsvFile(fileName);
        createListOfInvoices((ArrayList<Product>) products);
        fileUtils.logOrdersInfo(listOfInvoices);
    }

    private void createListOfInvoices(ArrayList<Product> listOfLoadedProducts) {
        for (int i = 0; i < 15; i++) {
            listOfInvoices.add(createInvoice(listOfLoadedProducts));
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

    public void getAnalyticalInformation() {
        final AnalyticalData analyticalData = new AnalyticalData();
        System.out.println("\nAmount of sold telephones: \n" + analyticalData.soldProductsByCategories(listOfInvoices, "Telephone"));
        System.out.println("\nAmount of sold television:  \n" + analyticalData.soldProductsByCategories(listOfInvoices, "Television"));
        System.out.println("\nCheck with minimal sum:  \n" + analyticalData.getCheckWithMinSum(listOfInvoices));
        System.out.println("\nSum of all checks:  \n" + analyticalData.countSumOfAllInvoices(listOfInvoices));
        System.out.println("\nChecks with one type products:  \n" + analyticalData.getChecksWithOneProductType(listOfInvoices));
        System.out.println("\nChecks with retail type:  \n" + analyticalData.countChecksWithRetailType(listOfInvoices));
        System.out.println("\nThree first checks:  \n" + analyticalData.getThreeFirstChecks(listOfInvoices));
        System.out.println("\nChecks with low_age type:  \n" + analyticalData.getLowAgeChecks(listOfInvoices));
        System.out.println("\nSorted checks:  \n" + analyticalData.getSortedChecks(listOfInvoices));
    }
}
