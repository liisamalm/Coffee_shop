package com.example.coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.val;

@Controller
public class CoffeeShopController {
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private OsastoRepository osastoRepository;

    @Autowired
    private ToimittajaRepository toimittajaRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @GetMapping
    public String home() {
        return "index";
    }
   
    @GetMapping("/kahvilaitteet")
    public String machines() {
        return "kahvilaitteet";
    }

    @GetMapping("/kulutustuotteet")
    public String products() {
        return "kulutustuotteet";
    }

    @GetMapping("/tuotteenhallinta")
    public String productMaintenance() {
        return "tuotteenhallinta";
    }

    

    



}


