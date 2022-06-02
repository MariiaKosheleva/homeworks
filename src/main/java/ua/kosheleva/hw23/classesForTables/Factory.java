package ua.kosheleva.hw23.classesForTables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Factory {
    String factoryId;
    String name;
    String country;

    public Factory() {
    }
}
