package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private LocalDate date;
    private Long usedTime;
    private Integer producedFuel;
    private Integer brokenChips;

    public Part(Long usedTime, Integer producedFuel, Integer brokenChips) {
        this.date = LocalDate.now();
        this.usedTime = usedTime;
        this.producedFuel = producedFuel;
        this.brokenChips = brokenChips;
    }
}
