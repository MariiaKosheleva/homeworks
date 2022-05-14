package ua.kosheleva.hw17;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Box {
    private double size;
    private List<Item> itemList;

    @Override
    public String toString() {
        return "Box size = " + String.format("%.0f", size) +
                ", itemList:  " + itemList;
    }
}

