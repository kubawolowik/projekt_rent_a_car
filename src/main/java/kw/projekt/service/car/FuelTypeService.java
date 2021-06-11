package kw.projekt.service.car;

import kw.projekt.model.car.FuelType;
import kw.projekt.model.car.projection.OurCarsPageFuelType;

import java.util.List;

public interface FuelTypeService {
    FuelType getFuelTypeByTypeName(String fuelTypeName);

    void save(FuelType fuelType);

    List<OurCarsPageFuelType> getOurCarsPageFuelTypes();
}
