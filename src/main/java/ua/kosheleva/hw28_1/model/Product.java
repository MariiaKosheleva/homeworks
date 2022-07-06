package ua.kosheleva.hw28_1.model;

import lombok.*;
import ua.kosheleva.hw28_1.interfaces.IBasicInfo;

@Data
public abstract class Product implements IBasicInfo {
    protected long id;
    protected boolean available;
    protected String title;
    protected double price;
    protected String channel;

    public abstract String getBasicInfo();
}
