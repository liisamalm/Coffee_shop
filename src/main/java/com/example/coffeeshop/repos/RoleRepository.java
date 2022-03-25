package com.example.coffeeshop.repos;

import com.example.coffeeshop.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long>{

    Role findByName(String name);

}