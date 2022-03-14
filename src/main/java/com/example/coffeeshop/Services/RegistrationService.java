package com.example.coffeeshop.Services;

import com.example.coffeeshop.Registration;
import com.example.coffeeshop.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class RegistrationService {

@Autowired
private RegistrationRepository registrationRepository;

public void addVip(@ModelAttribute Registration registration) {
    registrationRepository.save(registration);
    }
    
}

