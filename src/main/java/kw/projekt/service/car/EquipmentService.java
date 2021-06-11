package kw.projekt.service.car;

import kw.projekt.model.car.Equipment;

public interface EquipmentService {
    Equipment getEquipmentByItemName(String itemName);

    void save(Equipment equipment);
}