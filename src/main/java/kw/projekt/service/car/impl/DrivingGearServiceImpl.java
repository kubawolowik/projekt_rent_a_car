package kw.projekt.service.car.impl;

import kw.projekt.model.car.DrivingGear;
import kw.projekt.model.car.repository.DrivingGearRepository;
import kw.projekt.service.car.DrivingGearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrivingGearServiceImpl implements DrivingGearService {

    @Autowired
    private DrivingGearRepository drivingGearRepository;

    @Override
    public DrivingGear getDrivingGearByDrivingGearName(String drivingGearName) {
        return drivingGearRepository.getDrivingGearByDrivingGearName(drivingGearName);
    }

    @Override
    public void save(DrivingGear drivingGear) {
        drivingGearRepository.save(drivingGear);
    }
}