package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_color", uniqueConstraints = {@UniqueConstraint(columnNames = {"color_name"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_color_id")
    private int id;

    @OneToMany(
            mappedBy = "color",
            fetch = FetchType.LAZY)
    private List<Car> cars;

    @Column(name = "color_name")
    private String colorName;
}
