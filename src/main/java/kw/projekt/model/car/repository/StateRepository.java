package kw.projekt.model.car.repository;

import kw.projekt.model.car.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {

    State getStateByStateName(String stateName);
}
