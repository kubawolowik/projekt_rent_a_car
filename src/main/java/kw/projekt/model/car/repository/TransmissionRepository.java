package kw.projekt.model.car.repository;

import kw.projekt.model.car.Transmission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransmissionRepository extends CrudRepository<Transmission, Integer> {
    Transmission getTransmissionByTransmissionName(String transmissionName);
}
