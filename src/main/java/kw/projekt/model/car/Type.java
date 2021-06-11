package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_type", uniqueConstraints = {@UniqueConstraint(columnNames = {"type_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_type_id")
    private int id;

    @OneToMany(
            mappedBy = "type",
            fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;
}