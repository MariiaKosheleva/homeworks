package ua.kosheleva.hw28_1.utils;

import ua.kosheleva.hw28_1.enums.ProductType;
import ua.kosheleva.hw28_1.model.Product;
import ua.kosheleva.hw28_1.factory.ProductFactory;

import java.util.Random;

public class ProductGenerator {
    static ProductFactory productFactory = new ProductFactory();

    public Product generateRandomProduct() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return productFactory.getProduct(ProductType.PRODUCT_BUNDLE);
        } else {
            return productFactory.getProduct(ProductType.NOTIFIABLE_PRODUCT);
        }
    }
}
