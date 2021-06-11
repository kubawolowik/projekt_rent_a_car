package kw.projekt.model.car.repository;

import kw.projekt.model.car.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {

    Type getTypeByTypeName(String typeName);

    <T> Collection<T> findAllByOrderByTypeNameAsc(Class<T> tClass);

    default <T> Collection<T> getAll(Class<T> tClass) {
        return findAllByOrderByTypeNameAsc(tClass);
    }
}