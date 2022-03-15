package com.example.coffeeshop;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration extends AbstractPersistable<Long> {
 
    @Size(min = 4, max = 20, message = "Syötä 4-20 kirjainta.")
    private String name;

    @Size(min = 4, max = 50, message = "Syötä 4-50 kirjainta.")
    private String address;
    
    @NotEmpty(message = "Tämä kenttä ei saa olla tyhjä!")
    @Email
    private String email;

    @Size(min = 4, max = 10, message = "Syötä 4-10 kirjainta.")
    private String username;

    @Size(min = 4, max = 20, message = "Syötä 4-20 kirjainta.")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities;


}
