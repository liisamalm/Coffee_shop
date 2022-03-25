package com.example.coffeeshop.controller;

import javax.validation.Valid;
import com.example.coffeeshop.Services.UserService;
import com.example.coffeeshop.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ModelAttribute
    private UserData getUserData() {
        return new UserData();
    }

    @GetMapping("/registration")
    public String viewRegistration() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "vip";
        }
        return "redirect:/";
    }

    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute UserData userData, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "vip";
        }
        userService.createUser(userData);
        return "redirect:/";
        
    }
}





