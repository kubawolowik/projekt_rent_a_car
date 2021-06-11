package kw.projekt.model.contact.repository;

import kw.projekt.model.contact.WantToContact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WantToContactRepository extends CrudRepository<WantToContact, Integer> {
}