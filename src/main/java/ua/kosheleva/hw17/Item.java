package ua.kosheleva.hw17;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Item {
    private String name;
    private double cost;
    public Item(double cost, int itemNum) {
        this.name = String.valueOf(itemNum);
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item name = " + name  + ", cost = " + String.format("%.2f", cost);
    }
}
