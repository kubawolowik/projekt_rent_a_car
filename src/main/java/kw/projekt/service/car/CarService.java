package kw.projekt.service.car;

import kw.projekt.model.car.Car;
import kw.projekt.model.car.projection.CarDetailsPageCar;
import kw.projekt.model.car.projection.HomePageCar;
import kw.projekt.model.car.projection.OurCarsPageCar;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    void save(Car car);

    List<HomePageCar> getHomePageCars();

    Page<OurCarsPageCar> getOurCarsPageCars(String carType, String carBrand, String carModel, String carFuelType, String sortBy, String sortDirection, String carState, int page);

    long getNumberOfCars();

    long getNumberOfAvailableCars();

    CarDetailsPageCar getCarDetails(int carId);
}
