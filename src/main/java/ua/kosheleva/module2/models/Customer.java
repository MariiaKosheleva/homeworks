package ua.kosheleva.module2.models;

import lombok.Getter;

@Getter
public class Customer {
    private final long id;
    private final String email;
    private final int age;

    public Customer(long id, String email, int age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nID: " + getId() + " Email: " + getEmail() + " Age: " + getAge();
    }
}

