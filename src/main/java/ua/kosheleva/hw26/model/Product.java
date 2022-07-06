package ua.kosheleva.hw26.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product {
    private String id;
    private String orderId;
    private String name;
    private Float price;
    private Integer amount;

    public Product(String name, Float price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "\nProduct ID: " + getId() + ", order ID: " + getOrderId() + ", name: " + getName() +
                ", price: " + getPrice() + ", amount: " + getAmount();
    }
}
