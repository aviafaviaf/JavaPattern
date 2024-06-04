package com.example.practice15.models;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class AppUserDetails extends User implements org.springframework.security.core.userdetails.UserDetails {

    public AppUserDetails(Long id, String username, String password) {
        super(id, username, password);
    }

    public AppUserDetails(User user) {
        super(user.getId(), user.getUsername(), user.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
