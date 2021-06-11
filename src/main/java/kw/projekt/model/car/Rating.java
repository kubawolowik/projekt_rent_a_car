package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "car_rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_rating_id")
    private int id;

    @Column(name = "economy")
    private int economy;

    @Column(name = "comfort")
    private int comfort;

    @Column(name = "power")
    private int power;
}
