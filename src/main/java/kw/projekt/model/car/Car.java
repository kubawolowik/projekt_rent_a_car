package kw.projekt.model.car;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "engine")
    private String engine;

    @Column(name = "horse_power")
    private int horsePower;

    @Column(name = "production_date")
    private Date productionDate;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "fuel_condition")
    private float fuelCondition;

    @Column(name = "rent_price")
    private double rentPrice;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "full_description", columnDefinition = "TEXT")
    private String fullDescription;

    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driving_gear_id")
    private DrivingGear drivingGear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private List<Image> images;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @ManyToMany
    @JoinTable(
            name = "car_equipment",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;
}