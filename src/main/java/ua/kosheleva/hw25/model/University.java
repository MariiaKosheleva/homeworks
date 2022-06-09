package ua.kosheleva.hw25.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String universityName;

    @OneToMany(mappedBy = "university", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<UniversityGroup> universityGroups;

    public University(String universityName) {
        this.universityName = universityName;
    }
}
