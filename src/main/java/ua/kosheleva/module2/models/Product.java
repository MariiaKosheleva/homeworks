package ua.kosheleva.module2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Product {
    private final String series;
    private String screenType;
    private double price;
}
