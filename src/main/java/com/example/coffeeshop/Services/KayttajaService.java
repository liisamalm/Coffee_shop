/* package com.example.coffeeshop.Services;

import java.util.*;

import javax.transaction.Transactional;

import com.example.coffeeshop.RoleRepository;
import com.example.coffeeshop.Kayttaja;
import com.example.coffeeshop.KayttajaRepository;
import com.example.coffeeshop.KayttajanRooli;
import com.example.coffeeshop.KayttajanRooliRepository;
import com.example.coffeeshop.Role;
/* import com.example.coffeeshop.UserData;
import com.example.coffeeshop.UserRepository; */

/* import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute; */

 
/* @Service
public class KayttajaService {
    @Autowired
    private KayttajaRepository kayttajaRepository;

    @Autowired
    private KayttajanRooliRepository kayttajanRooliRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public Kayttaja getUser(String email){
        return kayttajaRepository.findByEmail(email);
    }

    public Kayttaja getUserById(Long id){
        return kayttajaRepository.getById(id);
    } */

    /* public void createUser(@ModelAttribute UserData userData) {
    userRepository.save(userData);
   }

   @Transactional
     public void createVip(UserData userData){
        Role role = roleRepository.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        
        userRepository.save(userData);
    }  */
     /* public void createKayttaja(String nimi, String osoite, String email, String tunnus, String salasana, Boolean isEnabled){
        KayttajanRooli kayttajanrooli = kayttajanRooliRepository.findByName("USER");
        Set<KayttajanRooli> roleSet = new HashSet<>();
        roleSet.add(kayttajanrooli);
        Kayttaja kayttaja = new Kayttaja();
        kayttaja.setNimi(nimi);
        kayttaja.setOsoite(osoite);
        kayttaja.setTunnus(tunnus);
        kayttaja.setEmail(email);
        
        kayttaja.setSalasana(passwordEncoder.encode(salasana));
        kayttaja.setEnabled(isEnabled);
        kayttaja.setKayttajanroolit(roleSet);
        kayttajaRepository.save(kayttaja);
    }
} */

    /* public void updateUser(Long id, String name, String username, String address, String phonenumber, String email){
        UserData user = userRepository.getById(id);
        user.setName(name);
        user.setUsername(username);
        user.setAddress(address);
        user.setEmail(email);
        userRepository.save(user);
    }

    public void resetPassword(String email, String password){
        UserData user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
    
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    } */
    

/* public void createKayttaja(String nimi, String osoite, String email, String tunnus, String salasana, Boolean isEnabled){
        KayttajanRooli rooli = kayttajanRooliRepository.findByName("USER");
        Set<KayttajanRooli> roleSet = new HashSet<>();
        roleSet.add(rooli);
        UserData user = new UserData();
        user.setName(name);
        user.setUsername(email);
        user.setAddress(address);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(isEnabled);
        user.setRoles(roleSet);
        userRepository.save(user);
    }  */