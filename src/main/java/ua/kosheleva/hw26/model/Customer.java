package ua.kosheleva.hw26.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class Customer {
    private String id;
    private String orderId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String status;

    public Customer(String firstName, String lastName, Integer age, String status) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nCustomer ID: " + getId() + ", order ID: " + getOrderId() + ", name: " + getFirstName() +
                " " + getLastName() + ", age: " + getAge() + ", status: " + getStatus();
    }
}
