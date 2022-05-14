package ua.kosheleva.hw18;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Box {
    private String from;
    private String material;
    private String color;
    private String unit;
    private int maxLiftingCapacity;
    private String cargoName;
    private String cargoClass;
    private LocalDateTime deliveryDate;

    void setDeliveryDateFromXML( String value) {
        setDeliveryDate(LocalDateTime.parse(value));
    }

    void setDeliveryDateFromJSON(String value) {
        setDeliveryDate(LocalDateTime.parse(value));
    }

    @Override
    public String toString() {
        return "from: " + from + "\nmaterial: " + material +
                ", color: " + color + "\nmaxLiftingCapacity = " +
                maxLiftingCapacity + ", unit: " + unit + "\ncargo name: " + cargoName +
                ", cargo class: " + cargoClass + "\ndelivery date: " + deliveryDate;
    }
}
