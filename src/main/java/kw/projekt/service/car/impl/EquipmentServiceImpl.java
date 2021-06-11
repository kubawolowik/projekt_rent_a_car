package kw.projekt.service.car.impl;

import kw.projekt.model.car.Equipment;
import kw.projekt.model.car.repository.EquipmentRepository;
import kw.projekt.service.car.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Equipment getEquipmentByItemName(String itemName) {
        return equipmentRepository.getEquipmentByItemName(itemName);
    }

    @Override
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }
}
