package kw.projekt.service.car.impl;

import kw.projekt.model.car.Color;
import kw.projekt.model.car.repository.ColorRepository;
import kw.projekt.service.car.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color getColorByColorName(String colorName) {
        return colorRepository.getColorByColorName(colorName);
    }

    @Override
    public void save(Color color) {
        colorRepository.save(color);
    }
}
