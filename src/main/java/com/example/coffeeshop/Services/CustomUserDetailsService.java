/* package com.example.coffeeshop.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.coffeeshop.Registration;
import com.example.coffeeshop.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private RegistrationRepository registrationRepository;

    
    @Autowired

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Registration registration = registrationRepository.findByUsername(username);
        if (registration == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String authority : registration.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }

        return new org.springframework.security.core.userdetails.User(
                registration.getUsername(),
                registration.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}

  */