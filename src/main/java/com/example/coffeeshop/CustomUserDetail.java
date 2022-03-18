package com.example.coffeeshop;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class CustomUserDetail implements UserDetails{
    private UserData userdata;

   public CustomUserDetail(UserData userdata){
    this.userdata = userdata;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = userdata.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
         
        return authorities;
    }
     @Override
    public String getPassword() {
        return userdata.getPassword();
    }
 
    @Override
    public String getUsername() {
        return userdata.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return userdata.isEnabled();
    }     
} 