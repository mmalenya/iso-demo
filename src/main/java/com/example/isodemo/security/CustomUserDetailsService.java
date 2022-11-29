package com.example.isodemo.security;

import com.example.isodemo.model.IsoUser;
import com.example.isodemo.repository.IsoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IsoUserRepository isoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<IsoUser> foundUser = isoUserRepository.findByUsername(username);

        if (!foundUser.isEmpty() == true) {

            IsoUser isoUser = foundUser.get(0);
            String role = isoUser.getRole();

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
            grantedAuthorities.add(authority);

            return new org.springframework.security.core.userdetails.User(isoUser.getUsername(), isoUser.getPassword(), grantedAuthorities);
        }

        throw new UsernameNotFoundException("User not found");
    }

}
