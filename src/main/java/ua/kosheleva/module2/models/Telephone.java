package ua.kosheleva.module2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Telephone extends Product {
    private final String model;

    public Telephone(String series, String model, String screenType, double price ) {
        super(series, screenType, price);
        this.model = model;
    }

    @Override
    public String toString() {
        return "\nSeries: " + getSeries() + " Model: " + getModel() + " ScreenType: " + getScreenType() +
                " Price: " + getPrice();
    }
}
