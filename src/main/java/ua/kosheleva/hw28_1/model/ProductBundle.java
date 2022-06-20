package ua.kosheleva.hw28_1.model;

import ua.kosheleva.hw28_1.interfaces.IAmountInBundle;

public class ProductBundle extends Product implements IAmountInBundle {
    protected int amount;

    protected ProductBundle(ProductBundleBuilder productBundleBuilder) {
        super(productBundleBuilder);
        this.amount = productBundleBuilder.amount;
    }

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

    public static class ProductBundleBuilder extends Builder {
        protected int amount;

        public ProductBundleBuilder(long id, boolean available, String title, double price, String channel) {
            super(id, available, title, price, channel);
        }

        public ProductBundleBuilder amount(int value) {
            amount = value;
            return this;
        }

        public Product build() {
            return new ProductBundle(this) {
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
            };
        }
    }
}
