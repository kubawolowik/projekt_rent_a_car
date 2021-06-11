package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment", uniqueConstraints = {@UniqueConstraint(columnNames = {"item_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_equipment_id")
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;


    @ManyToMany
    @JoinTable(
            name = "car_equipment",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars;
}
