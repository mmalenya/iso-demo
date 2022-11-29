package com.example.isodemo.security;

import com.example.isodemo.model.IsoUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class CustomUserDetails  implements UserDetails {

    private IsoUser isoUser;

    public CustomUserDetails( IsoUser isoUser){
        this.isoUser = isoUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return null;
    }

    @Override
    public String getPassword() {
        return isoUser.getPassword();
    }

    @Override
    public String getUsername() {
        return isoUser.getUsername();
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
