package ua.kosheleva.hw28_1;

import ua.kosheleva.hw28_1.model.Product;
import ua.kosheleva.hw28_1.utils.ProductFilter;
import ua.kosheleva.hw28_1.utils.ProductGenerator;
import ua.kosheleva.hw28_1.utils.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final ProductRepository repository = new ProductRepository();
    static final ProductGenerator productGenerator = new ProductGenerator();
    static final ProductFilter productFilter = new ProductFilter();

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(productGenerator.generateRandomProduct());
        products.add(productGenerator.generateRandomProduct());
        products.add(productGenerator.generateRandomProduct());
        products.add(productGenerator.generateRandomProduct());
        products.add(productGenerator.generateRandomProduct());

        products.forEach(repository::save);

        System.out.println();
        repository.getAll().forEach(product -> System.out.println(product.getBasicInfo()));
        System.out.println();
        System.out.println(repository.getAll());
        System.out.println("\nnotifications sent: " + productFilter.filterNotifiableProductsAndSendNotifications(repository) + "\n");
    }
}
