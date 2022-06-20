package ua.kosheleva.hw28_1.factory;

import ua.kosheleva.hw28_1.model.NotifiableProduct;
import ua.kosheleva.hw28_1.model.ProductBundle;
import ua.kosheleva.hw28_1.enums.ProductType;
import ua.kosheleva.hw28_1.model.Product;

import java.util.Random;

public class ProductFactory {
    static Random RANDOM = new Random();

    public Product getProduct(ProductType type) {
        Product product = null;
        switch (type) {
            case NOTIFIABLE_PRODUCT -> {
                product = createNotifiableProduct();
            }
            case PRODUCT_BUNDLE -> {
                product = createProductBundle();
            }
        }
        return product;
    }

    private ProductBundle createProductBundle() {
        long id = RANDOM.nextLong();
        boolean available = RANDOM.nextBoolean();
        String title = RANDOM.nextFloat() + "" + RANDOM.nextDouble();
        double price = RANDOM.nextDouble();
        String channel = RANDOM.nextBoolean() + "" + RANDOM.nextDouble();
        int amount = RANDOM.nextInt(15);
        return (ProductBundle) new ProductBundle.ProductBundleBuilder(id, available, title, price, channel)
                .amount(amount)
                .build();
    }

    private NotifiableProduct createNotifiableProduct() {
        long id = RANDOM.nextLong();
        boolean available = RANDOM.nextBoolean();
        String title = RANDOM.nextFloat() + "" + RANDOM.nextDouble();
        double price = RANDOM.nextDouble();
        String channel = RANDOM.nextBoolean() + "" + RANDOM.nextDouble();
        return (NotifiableProduct) new NotifiableProduct.NotifiableProductBuilder(id, available, title, price, channel)
                .build();
    }
}
