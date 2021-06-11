package kw.projekt.model.car.projection;

import org.springframework.beans.factory.annotation.Value;

public interface HomePageCar {

    @Value("#{target.id}")
    int getId();

    @Value("#{target.model.brand.brandName} #{target.model.modelName}")
    String getFullName();

    @Value("#{target.description}")
    String getDescription();

    @Value("#{target.type.typeName}")
    String getTypeName();

    @Value("#{target.images.size() > 0 ? ('/images/'+target.id+'/'+target.images.get(0).url) : '/images/no-image.jpg'}")
    String getImageUrl();

}