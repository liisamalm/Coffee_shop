package com.example.coffeeshop;

import com.example.coffeeshop.Services.TuotteenHallintaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeMachinesController {
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;


    @GetMapping("/kahvilaitteet")
    public String machines(Model model) {
        model.addAttribute("kahvilaitteet", tuoteRepository.findAllKahvilaitteet());
        return "kahvilaitteet";
    }

    @ResponseBody
    @GetMapping("/kahvilaite/tuoteKuva/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

    @GetMapping("/kahvilaitteet/{id}")
    public String showOneKahvilaite(Model model, @PathVariable Long id) {
        model.addAttribute("kahvilaite", tuotteenHallintaService.findTuote(id));
        return "kahvilaite";
    }
    
    @Secured("ADMIN")
    @GetMapping("/tuotteenhallinta")
    public String productMaintenance() {
        return "tuotteenhallinta";
    }
}
