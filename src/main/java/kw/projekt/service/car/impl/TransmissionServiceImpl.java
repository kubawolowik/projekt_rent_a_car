package kw.projekt.service.car.impl;

import kw.projekt.model.car.Transmission;
import kw.projekt.model.car.repository.TransmissionRepository;
import kw.projekt.service.car.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmissionServiceImpl implements TransmissionService {

    @Autowired
    private TransmissionRepository transmissionRepository;

    @Override
    public Transmission getTransmissionByTransmissionName(String transmissionName) {
        return transmissionRepository.getTransmissionByTransmissionName(transmissionName);
    }

    @Override
    public void save(Transmission transmission) {
        transmissionRepository.save(transmission);
    }
}