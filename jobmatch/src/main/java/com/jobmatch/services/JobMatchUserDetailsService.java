package com.jobmatch.services;

import com.jobmatch.models.User;
import com.jobmatch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JobMatchUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JobMatchUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        return new UserRepositoryUserDetails(user);
    }

    private final static class UserRepositoryUserDetails implements UserDetails {
        private static final long serialVersionUID = 1L;
        private User user;

        private UserRepositoryUserDetails(User user) {
            this.user = user;
        }
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        }
        public String getUsername() {
            return user.getUsername();
        }
        public boolean isAccountNonExpired() {
            return true;
        }
        public boolean isAccountNonLocked() {
            return true;
        }
        public boolean isCredentialsNonExpired() {
            return true;
        }
        public boolean isEnabled() {
            return true;
        }
        public String getPassword() {
            return user.getPassword();
        }
    }

}