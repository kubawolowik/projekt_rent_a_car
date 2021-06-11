package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fuel_type", uniqueConstraints = {@UniqueConstraint(columnNames = {"type_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_type_id")
    private int id;

    @OneToMany(
            mappedBy = "fuelType",
            fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "type_name")
    private String typeName;
}