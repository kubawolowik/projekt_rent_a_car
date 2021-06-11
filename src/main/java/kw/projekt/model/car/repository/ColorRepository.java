package kw.projekt.model.car.repository;

import kw.projekt.model.car.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color, Integer> {

    Color getColorByColorName(String colorName);
}