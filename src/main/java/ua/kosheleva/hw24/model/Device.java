package ua.kosheleva.hw24.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String model;
    private String type;
    private Integer price;
    private LocalDate date;
    private String description;
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    @Override
    public String toString() {
        return "\n\nFactory name: " + getFactory().getName() + "\nDevice id: " + getId() + "\nModel: " + getModel() + "\nType: " + getType() +
                "\nPrice: " + getPrice() + "\nCreation date: " + getDate() +
                "\nDescription: " + getDescription() + "\nAvailability: " + getAvailability();
    }

    public Device(String type, String model, Integer price, LocalDate date,
                  String description, Boolean availability, Factory factory) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.date = date;
        this.description = description;
        this.availability = availability;
        this.factory = factory;
    }
}
