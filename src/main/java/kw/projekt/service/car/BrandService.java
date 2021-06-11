package kw.projekt.service.car;

import kw.projekt.model.car.Brand;
import kw.projekt.model.car.projection.OurCarsPageBrand;

import java.util.List;

public interface BrandService {
    Brand getBrandByBrandName(String brand_name);

    void save(Brand brand);

    List<OurCarsPageBrand> getOurCarsPageBrands();
}