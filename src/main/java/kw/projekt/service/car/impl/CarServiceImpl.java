package kw.projekt.service.car.impl;

import kw.projekt.model.car.Car;
import kw.projekt.model.car.projection.CarDetailsPageCar;
import kw.projekt.model.car.projection.HomePageCar;
import kw.projekt.model.car.projection.OurCarsPageCar;
import kw.projekt.model.car.repository.CarRepository;
import kw.projekt.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<HomePageCar> getHomePageCars() {
        List<HomePageCar> allCars = (List<HomePageCar>) carRepository.findAllBy(HomePageCar.class);
        List<HomePageCar> homePageCars = new ArrayList<>();
        Random random = new Random();

        if (allCars.size() > 0)
            for (int i = 0; i < 8; i++)
                homePageCars.add(allCars.get(random.nextInt(allCars.size())));
        return homePageCars;
    }

    @Override
    public Page<OurCarsPageCar> getOurCarsPageCars(String carType, String carBrand, String carModel, String carFuelType,
                                                   String sortBy, String sortDirection, String carState, int pageNr) {
        PageRequest page = PageRequest.of(pageNr, 10, sortOrder(sortBy, sortDirection));

        boolean sType = (!carType.equals("") && !carType.equals("all"));
        boolean sBrand = (!carBrand.equals("") && !carBrand.equals("all"));
        boolean sModel = (!carModel.equals("") && !carModel.equals("all"));
        boolean sFuel = (!carFuelType.equals("") && !carFuelType.equals("all"));
        boolean sState = (!carState.equals("") && !carState.equals("all"));

        return carRepository.searchForCars(
                sBrand ? Optional.of(carBrand) : Optional.empty(),
                sModel ? Optional.of(carModel) : Optional.empty(),
                sType ? Optional.of(carType) : Optional.empty(),
                sFuel ? Optional.of(carFuelType) : Optional.empty(),
                sState ? Optional.of(carState) : Optional.empty(),
                page, OurCarsPageCar.class);
    }

    @Override
    public long getNumberOfCars() {
        return carRepository.count();
    }

    @Override
    public long getNumberOfAvailableCars() {
        return carRepository.countByState_StateName("Available");
    }

    @Override
    public CarDetailsPageCar getCarDetails(int carId) {
        return carRepository.findAllById(carId);
    }

    private Sort sortOrder(String sortBy, String direction) {
        direction = direction.toLowerCase();
        sortBy = sortBy.toLowerCase();
        Sort sort;

        switch (sortBy) {
            case "price":
                if (direction.equals("asc"))
                    sort = Sort.by(
                            new Sort.Order(Sort.Direction.ASC, "rentPrice"));
                else sort = Sort.by(
                        new Sort.Order(Sort.Direction.DESC, "rentPrice"));
                break;
            default:
                sort = Sort.by(
                        new Sort.Order(Sort.Direction.ASC, "rentPrice"));
                break;
        }
        return sort;
    }
}