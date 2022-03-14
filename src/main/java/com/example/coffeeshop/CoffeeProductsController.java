package com.example.coffeeshop;

import com.example.coffeeshop.Services.TuotteenHallintaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeProductsController {

    @GetMapping("/kulutustuotteet")
    public String products() {
        return "kulutustuotteet";
    }
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    @GetMapping("/kulutustuotteet")
    public String machines(Model model) {
        model.addAttribute("kulutustuotteet", tuoteRepository.findAllKulutustuotteet());
        return "kulutustuotteet";
    }

    @ResponseBody
    @GetMapping("/kulutustuote/tuoteKuva/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

    @GetMapping("/kulutustuote/{id}")
    public String showOneKulutustuote() {
        return "kulutustuote";
    }

}
