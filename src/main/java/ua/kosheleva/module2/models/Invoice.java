package ua.kosheleva.module2.models;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Getter
@Setter
public class Invoice {
    private static double limit;
    private final Product[] products;
    private final Customer customer;
    private Date dateTime;
    private CheckType type;
    private final int invoiceNum;
    private static int amountOfInvoices;

    public Invoice(Product[] products, Customer customer, Date dateTime) {
        this.products = products;
        this.customer = customer;
        this.dateTime = dateTime;
        invoiceNum = ++amountOfInvoices;
    }

    public static void setLimit(double inputLimit) throws IllegalAccessException {
        if(limit < 0){
            throw new IllegalArgumentException("The limit must be more than 0!");
        }
        Invoice.limit = inputLimit;
    }

    public void setType(){
        if(countCheckSum() > limit){
            type = CheckType.WHOlE_SALE;
        }else {
            type = CheckType.RETAIL;
        }
    }

    public void setType(CheckType type) {
        this.type = type;
    }

    public int amountOfProducts(){
        return products.length;
    }

    public double countCheckSum(){
        return Arrays.stream(products)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private String dateFormatter(){
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.dateTime);
    }

    private String outPutInfoAboutProducts(){
        return Arrays.stream(products)
                .map(Product::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return "Date/time: " + dateFormatter() + "\nAmount of products: " + invoiceNum +
                "\nCustomer information: " + customer.toString() + "\nCheckType: " + type +
                "\nOrder information: " + outPutInfoAboutProducts() + "\nCheckSum: " + countCheckSum();
    }
}
