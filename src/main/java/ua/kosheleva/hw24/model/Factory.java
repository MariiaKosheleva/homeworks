package ua.kosheleva.hw24.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import ua.kosheleva.hw24.model.Device;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "factory", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Device> deviceSet;

    @Override
    public String toString() {
        return "\nFactory id: " + getId() + "\nName: " + getName() + "\nCountry: " + getCountry();
    }

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
