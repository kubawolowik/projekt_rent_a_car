package kw.projekt.model.car.repository;

import kw.projekt.model.car.Car;
import kw.projekt.model.car.projection.CarDetailsPageCar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    long countByState_StateName(@Param("stateName") String stateName);

    <T> Collection<T> findAllBy(Class<T> type);

    @Query("select car from Car car where " +
            "(:brandName is null or car.model.brand.brandName = :brandName) and " +
            "(:modelName is null or car.model.modelName = :modelName) and " +
            "(:typeName is null or car.type.typeName = :typeName) and " +
            "(:fuelTypeName is null or car.fuelType.typeName = :fuelTypeName) and " +
            "(:stateName is null or car.state.stateName = :stateName)")
    <T> Page<T> searchForCars(
            @Param("brandName") Optional<String> brandName,
            @Param("modelName") Optional<String> modelName,
            @Param("typeName") Optional<String> typeName,
            @Param("fuelTypeName") Optional<String> fuelTypeName,
            @Param("stateName") Optional<String> stateName,
            Pageable pageable, Class<T> tClass
    );

    CarDetailsPageCar findAllById(int carId);
}