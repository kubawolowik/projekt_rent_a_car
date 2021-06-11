package kw.projekt.service.car;

import kw.projekt.model.car.Color;

public interface ColorService {
    Color getColorByColorName(String colorName);

    void save(Color color);
}