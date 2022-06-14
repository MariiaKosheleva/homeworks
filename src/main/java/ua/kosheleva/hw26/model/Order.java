package ua.kosheleva.hw26.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
public class Order {
    private String id;
    private String date;
    private String customerId;
    private List<String> products;

    public Order() {
        this.date = String.valueOf(LocalDate.now());
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "\nOrder ID: " + getId() + ", date: " + getDate() + ", customer: " + getCustomerId() +
                ", products: " + getProducts().toString();
    }
}
