package ua.kosheleva.hw25.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Curator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String curatorName;
    private LocalDate dateOfBirth;
    private Integer workExperience;

    @OneToOne
    private UniversityGroup universityGroup;

    public Curator(String curatorName, LocalDate dateOfBirth, Integer workExperience) {
        this.curatorName = curatorName;
        this.dateOfBirth = dateOfBirth;
        this.workExperience = workExperience;
    }
}
