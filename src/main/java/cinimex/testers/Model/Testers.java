package cinimex.testers.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "testers")
@Getter
@Setter
@ToString
public class Testers extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "testers_position")
    private String testers_position;

    @Column(name = "testers_skill")
    private String testers_skill;

    @Column(name = "experience")
    private BigDecimal experience;

    @Column(name = "location")
    private String location;


}
