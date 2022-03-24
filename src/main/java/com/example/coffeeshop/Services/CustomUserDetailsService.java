package com.example.coffeeshop.Services;

import com.example.coffeeshop.CustomUserDetail;
import com.example.coffeeshop.UserData;
import com.example.coffeeshop.UserRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData customer = userRepository.findByUsername(username).get();
        if(customer == null){
            throw new UsernameNotFoundException("No such user " + username);
        }

        return new CustomUserDetail(customer);
    }
} 

