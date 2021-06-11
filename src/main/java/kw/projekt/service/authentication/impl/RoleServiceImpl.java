package kw.projekt.service.authentication.impl;

import kw.projekt.exception.RoleAlreadyExistsException;
import kw.projekt.model.authentication.Role;
import kw.projekt.model.authentication.repository.RoleRepository;
import kw.projekt.service.authentication.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private Role getRoleByRoleName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }

    @Override
    public void addRole(Role role) {
        if (this.getRoleByRoleName(role.getRoleName()) != null)
            throw new RoleAlreadyExistsException("Role with this name already exists.");
        roleRepository.save(role);
    }
}
