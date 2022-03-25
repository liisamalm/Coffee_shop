package com.example.coffeeshop.Services;

import java.util.*;

import com.example.coffeeshop.model.Role;
import com.example.coffeeshop.model.UserData;
import com.example.coffeeshop.repos.RoleRepository;
import com.example.coffeeshop.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ModelAttribute
    private UserData getUserData() {
        return new UserData();
    }
    
    public UserData getUser(String email){
        return userRepository.findByEmail(email);
    }

    public UserData getUserById(Long id){
        return userRepository.getById(id);
    }

     public void createUser(UserData userData){
        Role role = roleRepository.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        userData.setRoles(roleSet);
        userData.setEnabled(true);
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        userRepository.save(userData);
    }  
}

