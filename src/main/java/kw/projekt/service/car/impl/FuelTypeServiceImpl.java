package kw.projekt.service.car.impl;

import kw.projekt.model.car.FuelType;
import kw.projekt.model.car.projection.OurCarsPageFuelType;
import kw.projekt.model.car.repository.FuelTypeRepository;
import kw.projekt.service.car.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Override
    public FuelType getFuelTypeByTypeName(String fuelTypeName) {
        return fuelTypeRepository.getFuelTypeByTypeName(fuelTypeName);
    }

    @Override
    public void save(FuelType fuelType) {
        fuelTypeRepository.save(fuelType);
    }

    @Override
    public List<OurCarsPageFuelType> getOurCarsPageFuelTypes() {
        return (List<OurCarsPageFuelType>) fuelTypeRepository.getAll(OurCarsPageFuelType.class);
    }
}
