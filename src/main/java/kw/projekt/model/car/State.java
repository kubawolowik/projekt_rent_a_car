package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "state", uniqueConstraints = {@UniqueConstraint(columnNames = {"state_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int id;

    @OneToMany(
            mappedBy = "state",
            fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "description")
    private String description;
}
