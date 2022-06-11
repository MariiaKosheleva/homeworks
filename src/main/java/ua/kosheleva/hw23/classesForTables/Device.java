package ua.kosheleva.hw23.classesForTables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Device {
    Integer id;
    String type;
    String model;
    Integer price;
    LocalDate date;
    String description;
    Boolean availability;
    String factoryId;

    public Device() {
    }
}
