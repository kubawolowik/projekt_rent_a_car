package kw.projekt.service.car.impl;

import kw.projekt.model.car.Brand;
import kw.projekt.model.car.projection.OurCarsPageBrand;
import kw.projekt.model.car.repository.BrandRepository;
import kw.projekt.service.car.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand getBrandByBrandName(String brand_name) {
        return brandRepository.getBrandByBrandName(brand_name);
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public List<OurCarsPageBrand> getOurCarsPageBrands() {
        return (List<OurCarsPageBrand>) brandRepository.getAll(OurCarsPageBrand.class);
    }
}
