package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_transmission", uniqueConstraints = {@UniqueConstraint(columnNames = {"transmission_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_transmission_id")
    private int id;

    @OneToMany(
            mappedBy = "transmission",
            fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "transmission_name")
    private String transmissionName;
}