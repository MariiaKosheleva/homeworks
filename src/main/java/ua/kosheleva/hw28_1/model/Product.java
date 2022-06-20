package ua.kosheleva.hw28_1.model;

import lombok.*;
import ua.kosheleva.hw28_1.interfaces.IBasicInfo;

@Data
public abstract class Product implements IBasicInfo {
    protected long id;
    protected boolean available;
    protected String title;
    protected double price;
    protected String channel;

    protected Product(Builder builder) {
        this.id = builder.id;
        this.available = builder.available;
        this.title = builder.title;
        this.price = builder.price;
        this.channel = builder.channel;
    }

    public abstract String getBasicInfo();

    public static class Builder {
        protected long id;
        protected boolean available;
        protected String title;
        protected double price;
        protected String channel;

        public Builder(long id, boolean available, String title, double price, String channel) {
            this.id = id;
            this.available = available;
            this.title = title;
            this.price = price;
            this.channel = channel;
        }

        public Product build() {
            return new Product(this) {
                @Override
                public String getBasicInfo() {
                    return "Product{" +
                            "id=" + id +
                            ", available=" + available +
                            ", title='" + title + '\'' +
                            ", price=" + price +
                            '}';
                }
            };
        }
    }
}
