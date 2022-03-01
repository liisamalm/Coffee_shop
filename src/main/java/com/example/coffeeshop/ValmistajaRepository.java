package com.example.coffeeshop;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ValmistajaRepository extends JpaRepository<Valmistaja, Long>{
    
    
}
