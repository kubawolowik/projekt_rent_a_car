package kw.projekt.model.authentication.repository;

import kw.projekt.model.authentication.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role getRoleByRoleName(String roleName);
}