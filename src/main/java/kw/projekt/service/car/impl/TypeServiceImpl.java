package kw.projekt.service.car.impl;

import kw.projekt.model.car.Type;
import kw.projekt.model.car.projection.OurCarsPageType;
import kw.projekt.model.car.repository.TypeRepository;
import kw.projekt.service.car.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type getTypeByTypeName(String typeName) {
        return typeRepository.getTypeByTypeName(typeName);
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public List<OurCarsPageType> getOurCarsPageTypes() {
        return (List<OurCarsPageType>) typeRepository.getAll(OurCarsPageType.class);
    }
}