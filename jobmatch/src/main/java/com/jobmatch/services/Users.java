package com.jobmatch.services;

import com.jobmatch.configuration.SecurityConfiguration;
import com.jobmatch.models.User;
import com.jobmatch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Users implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public Users(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), SecurityConfiguration.getAuthoritiesCollection());
    }
}
