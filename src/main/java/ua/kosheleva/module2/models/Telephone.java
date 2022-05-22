package ua.kosheleva.module2.models;

import lombok.Getter;

@Getter
public class Telephone extends Product {
    private final String model;

    public Telephone(String series, String model, String screenType, double price) {
        super(series, screenType, price);
        this.model = model;
    }

    @Override
    public String toString() {
        return "\nTelephone series: " + getSeries() + " Model: " + getModel() + " ScreenType: " + getScreenType() +
                " Price: " + getPrice();
    }
}
