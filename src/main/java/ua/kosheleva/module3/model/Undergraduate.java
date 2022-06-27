package ua.kosheleva.module3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ua.kosheleva.hw25.model.Course;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Undergraduate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dateOfAdmission;

    @ManyToOne
    @JoinColumn(name = "uniGroup_id")
    UniGroup uniGroup;

    @OneToMany(mappedBy = "undergraduate", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Mark> marks;
}
