package com.example.coffeeshop;

import com.example.coffeeshop.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String viewRegistration(@ModelAttribute UserData userData) {
        return "vip";
    }

    @PostMapping("/registration")
    public String createUser(@Valid @ModelAttribute UserData userData, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "vip";
        }
        userService.createUser(userData);
        return "redirect:/";
        
    }
}





