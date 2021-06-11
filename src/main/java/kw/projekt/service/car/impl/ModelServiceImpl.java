package kw.projekt.service.car.impl;

import kw.projekt.model.car.Brand;
import kw.projekt.model.car.Model;
import kw.projekt.model.car.projection.OurCarsPageModel;
import kw.projekt.model.car.repository.ModelRepository;
import kw.projekt.service.car.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model getModelByBrandAndModelName(Brand brand, String modelName) {
        return modelRepository.getModelByBrandAndModelName(brand, modelName);
    }

    @Override
    public void save(Model model) {
        modelRepository.save(model);
    }

    @Override
    public List<OurCarsPageModel> getOurCarsPageModels(String brandName) {
        return (List<OurCarsPageModel>) modelRepository.getBrandName(brandName, OurCarsPageModel.class);
    }
}
