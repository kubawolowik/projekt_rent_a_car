package kw.projekt.service.authentication.impl;

import kw.projekt.exception.UserAlreadyExistsException;
import kw.projekt.model.authentication.Role;
import kw.projekt.model.authentication.User;
import kw.projekt.model.authentication.repository.UserRepository;
import kw.projekt.service.authentication.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Invalid username or password.");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    private User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        if (this.getUserByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistsException("User with this username already exists.");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}