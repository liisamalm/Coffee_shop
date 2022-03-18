package com.example.coffeeshop;

import com.example.coffeeshop.Services.TuotteenHallintaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.val;

@Controller
public class CoffeeShopController {
    
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/signin")
    public String vipHome() {
        return "index";
    }
   
    

   
}

    






