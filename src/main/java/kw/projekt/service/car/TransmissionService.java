package kw.projekt.service.car;

import kw.projekt.model.car.Transmission;

public interface TransmissionService {

    Transmission getTransmissionByTransmissionName(String transmissionName);

    void save(Transmission transmission);
}
