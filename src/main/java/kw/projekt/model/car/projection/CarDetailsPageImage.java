package kw.projekt.model.car.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CarDetailsPageImage {

    @Value("#{'/images/'+target.car.id+'/'+target.url}")
    String getUrl();

}