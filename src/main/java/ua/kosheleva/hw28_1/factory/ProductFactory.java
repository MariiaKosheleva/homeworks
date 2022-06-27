package ua.kosheleva.hw28_1.factory;

import ua.kosheleva.hw28_1.model.NotifiableProduct;
import ua.kosheleva.hw28_1.model.ProductBundle;
import ua.kosheleva.hw28_1.enums.ProductType;
import ua.kosheleva.hw28_1.model.Product;

import java.util.Random;

public class ProductFactory {
    static Random RANDOM = new Random();

    public Product getProduct(ProductType type) {
        Product product;
        switch (type) {
            case NOTIFIABLE_PRODUCT -> product = createNotifiableProduct();
            case PRODUCT_BUNDLE -> product = createProductBundle();
            default -> throw new IllegalArgumentException("This type of product is illegal: " + type);
        }
        return product;
    }

    private NotifiableProduct createNotifiableProduct() {
        return new NotifiableProduct.NotifiableProductBuilder()
                .setIdValue(RANDOM.nextLong())
                .setAvailableValue(RANDOM.nextBoolean())
                .setTitleValue(RANDOM.nextFloat() + "" + RANDOM.nextDouble())
                .setPriceValue(RANDOM.nextDouble())
                .setChannelValue(RANDOM.nextBoolean() + "" + RANDOM.nextDouble())
                .build();
    }

    private ProductBundle createProductBundle() {
        return new ProductBundle.ProductBundleBuilder()
                .setIdValue(RANDOM.nextLong())
                .setAvailableValue(RANDOM.nextBoolean())
                .setTitleValue(RANDOM.nextFloat() + "" + RANDOM.nextDouble())
                .setPriceValue(RANDOM.nextDouble())
                .setChannelValue(RANDOM.nextBoolean() + "" + RANDOM.nextDouble())
                .setAmountValue(RANDOM.nextInt(15))
                .build();
    }
}
