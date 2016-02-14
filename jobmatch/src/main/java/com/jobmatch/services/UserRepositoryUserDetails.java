package com.jobmatch.services;

import com.jobmatch.configuration.SecurityConfiguration;
import com.jobmatch.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserRepositoryUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private User user;

    public UserRepositoryUserDetails(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return SecurityConfiguration.getAuthoritiesCollection();
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