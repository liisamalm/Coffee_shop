package com.example.coffeeshop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

    Registration findByUsername(String username);
    
}