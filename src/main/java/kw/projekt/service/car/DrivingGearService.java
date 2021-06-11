package kw.projekt.service.car;

import kw.projekt.model.car.DrivingGear;
public interface DrivingGearService {
    DrivingGear getDrivingGearByDrivingGearName(String drivingGearName);

    void save(DrivingGear drivingGear);
}
