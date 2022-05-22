package ua.kosheleva.module2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Television extends Product {
    private final double diagonal;
    private final String country;

    public Television(String series, double diagonal, String screenType, String country, double price) {
        super(series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nSeries: " + getSeries() + " Diagonal: " + getDiagonal() +
                " ScreenType: " + getScreenType() +
                " Country: " + getCountry() +
                " Price: " + getPrice();
    }
}
