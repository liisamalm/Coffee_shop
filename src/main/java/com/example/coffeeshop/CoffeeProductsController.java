package com.example.coffeeshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeProductsController {

    @GetMapping("/kulutustuotteet")
    public String products() {
        return "kulutustuotteet";
    }
    
}
