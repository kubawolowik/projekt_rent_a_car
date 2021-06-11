package kw.projekt.service.car;

import kw.projekt.model.car.Type;
import kw.projekt.model.car.projection.OurCarsPageType;

import java.util.List;

public interface TypeService {
    Type getTypeByTypeName(String typeName);

    void save(Type type);

    List<OurCarsPageType> getOurCarsPageTypes();
}