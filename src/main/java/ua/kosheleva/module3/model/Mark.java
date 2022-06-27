package ua.kosheleva.module3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "undergraduate_id")
    private Undergraduate undergraduate;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
