package kw.projekt.model.authentication.repository;

import kw.projekt.model.authentication.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserByUsername(String username);
}