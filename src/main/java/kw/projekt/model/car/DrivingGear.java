package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_driving_gear", uniqueConstraints = {@UniqueConstraint(columnNames = {"driving_gear_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrivingGear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_driving_gear_id")
    private int id;

    @OneToMany(
            mappedBy = "drivingGear",
            fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "driving_gear_name")
    private String drivingGearName;
}