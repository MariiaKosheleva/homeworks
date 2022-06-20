package ua.kosheleva.hw28_1.model;

import lombok.Setter;
import ua.kosheleva.hw28_1.interfaces.IAmountInBundle;
@Setter
public class ProductBundle extends Product implements IAmountInBundle {
    protected int amount;

    @Override
    public int getAmountInBundle() {
        return amount;
    }

    @Override
    public String getBasicInfo() {
        return "ProductBundle { " +
                "channel = " + channel + '\'' +
                ", id = " + id +
                ", available = " + available +
                ", title = " + title + '\'' +
                ", price = " + price +
                ", amountInBundle = " + amount +
                " }";
    }

    public static class ProductBundleBuilder {
        private final ProductBundle productBundle;

        public ProductBundleBuilder() {
            productBundle = new ProductBundle();
        }

        public ProductBundleBuilder setWithId(long id) {
            productBundle.setId(id);
            return this;
        }

        public ProductBundleBuilder setWithAvailable(boolean available) {
            productBundle.setAvailable(available);
            return this;
        }

        public ProductBundleBuilder setWithTitle(String title) {
            productBundle.setTitle(title);
            return this;
        }

        public ProductBundleBuilder setWithPrice(double price) {
            productBundle.setPrice(price);
            return this;
        }

        public ProductBundleBuilder setWithChannel(String channel) {
            productBundle.setChannel(channel);
            return this;
        }

        public ProductBundleBuilder setWithAmount(int amount) {
            productBundle.setAmount(amount);
            return this;
        }

        public ProductBundle build() {
            return productBundle;
        }
    }
}
