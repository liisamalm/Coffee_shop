package com.example.coffeeshop.repos;

import java.util.Optional;

import com.example.coffeeshop.model.UserData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long>{

    UserData findByName(String name);
    UserData findByEmail(String email);

    Optional<UserData> findByUsername(String username);
    
    
}
