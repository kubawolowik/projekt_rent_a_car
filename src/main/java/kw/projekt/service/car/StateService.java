package kw.projekt.service.car;

import kw.projekt.model.car.State;

public interface StateService {
    State getStateByStateName(String stateName);

    void save(State state);
}