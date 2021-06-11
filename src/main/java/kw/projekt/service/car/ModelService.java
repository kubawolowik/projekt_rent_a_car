package kw.projekt.service.car;

import kw.projekt.model.car.Brand;
import kw.projekt.model.car.Model;
import kw.projekt.model.car.projection.OurCarsPageModel;

import java.util.List;

public interface ModelService {
    Model getModelByBrandAndModelName(Brand brand, String modelName);

    void save(Model model);

    List<OurCarsPageModel> getOurCarsPageModels(String brandName);
}
