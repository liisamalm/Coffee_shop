package com.example.coffeeshop;

import com.example.coffeeshop.Services.ToimittajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToimittajaController {

    @Autowired
    private ToimittajaService toimittajaService;


    @GetMapping("/toimittajan-muokkaus")
    public String listToimittajat(Model model) {
        model.addAttribute("toimittajat", toimittajaService.getAllToimittajat());
        return "toimittajan-muokkaus";
        
    }

    @PostMapping("/toimittajan-muokkaus")
    public String addValmistaja(@ModelAttribute Toimittaja toimittaja) {
       toimittajaService.addToimittaja(toimittaja);
        return "redirect:/toimittajan-muokkaus";
    }
    
}
