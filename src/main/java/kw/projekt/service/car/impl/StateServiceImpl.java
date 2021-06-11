package kw.projekt.service.car.impl;

import kw.projekt.model.car.State;
import kw.projekt.model.car.repository.StateRepository;
import kw.projekt.service.car.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State getStateByStateName(String stateName) {
        return stateRepository.getStateByStateName(stateName);
    }

    @Override
    public void save(State state) {
        stateRepository.save(state);
    }
}