package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_model_id")
    private int id;

    @Column(name = "model_name")
    private String modelName;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "model")
    private List<Car> cars;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
