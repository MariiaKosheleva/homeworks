package ua.kosheleva.hw25.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String courseName;
    private Integer complexity;

    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet;

    public Course(String courseName, Integer complexity) {
        this.courseName = courseName;
        this.complexity = complexity;
    }
}
