package kw.projekt.model.car.repository;

import kw.projekt.model.car.DrivingGear;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingGearRepository extends CrudRepository<DrivingGear, Integer> {
    DrivingGear getDrivingGearByDrivingGearName(String drivingGearName);
}