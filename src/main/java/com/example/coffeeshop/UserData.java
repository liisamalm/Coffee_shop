package com.example.coffeeshop;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData extends AbstractPersistable<Long>{
    
    @NotEmpty
    @Size(min = 3, max = 50, message = "Nimen tulee olla 3 - 20 merkkiä pitkä")
    private String name;


    @NotEmpty
    @Size(min = 10, max = 50, message = "Osoitteen tulee olla 10 - 50 merkkiä pitkä")
    private String address;
    
   
    @Column(unique = true)
    @NotEmpty (message = "Tämä kenttä ei saa olla tyhjä!")
    @Email
    private String email;

    
    @NotEmpty
    @Size(min = 4, max = 20, message = "Käyttäjätunnus tulee sisältää 4-20 kirjainta")
    private String username;

    @NotEmpty
    @Size(min = 4, max = 20, message = "Käyttäjätunnus tulee sisältää 4-10 merkkiä")
    private String password;

    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>();

    public void orElseThrow(Object object) {
    }
  

}