package kw.projekt.model.contact.repository;

import kw.projekt.model.contact.ContactState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactStateRepository extends CrudRepository<ContactState, Integer> {

    ContactState getStateByStateName(String stateName);
}