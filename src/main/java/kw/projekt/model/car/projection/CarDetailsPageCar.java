package kw.projekt.model.car.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

public interface CarDetailsPageCar {

    @Value("#{target.id}")
    int getId();

    @Value("#{target.model.brand.brandName}")
    String getBrand();

    @Value("#{target.model.modelName}")
    String getModel();

    @Value("#{target.images}")
    List<CarDetailsPageImage> getImages();

    @Value("#{target.color.colorName}")
    String getColor();

    @Value("#{target.fuelType.typeName}")
    String getFuelType();

    @Value("#{target.rentPrice}")
    Double getRentPrice();

    @Value("#{target.state.stateName}")
    String getState();

    @Value("#{target.type.typeName}")
    String getType();

    @Value("#{target.engine}")
    String getEngine();

    @Value("#{target.horsePower}")
    String getHorsePower();

    @Value("#{target.description}")
    String getDescription();

    @Value("#{target.fullDescription}")
    String getFullDescription();

    @Value("#{target.rating.economy}")
    Integer getEconomyRating();

    @Value("#{target.rating.comfort}")
    Integer getComfortRating();

    @Value("#{target.rating.power}")
    int getPowerRating();

    @Value("#{target.productionDate}")
    Date getProdDate();

    @Value("#{target.mileage}")
    int getMileage();

    @Value("#{target.transmission.transmissionName}")
    String getTransmission();

    @Value("#{target.drivingGear.drivingGearName}")
    String getDrivingGear();

    @Value("#{target.numberOfDoors}")
    int getNumberOfDoors();

    @Value("#{target.numberOfSeats}")
    int getNumberOfSeats();

    @Value("#{target.equipment}")
    List<CarDetailsPageEquipment> getEquipment();

}
