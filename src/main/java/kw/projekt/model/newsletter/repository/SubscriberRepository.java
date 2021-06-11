package kw.projekt.model.newsletter.repository;

import kw.projekt.model.newsletter.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {

    int countByEmail(String email);
}