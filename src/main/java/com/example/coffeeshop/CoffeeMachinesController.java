package com.example.coffeeshop;

import java.util.Collection;

import com.example.coffeeshop.Services.TuotteenHallintaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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


    @GetMapping(path= {"/kahvilaitteet", "/search"})
    public String machines(Model model, @Param("hakusana") String hakusana) {
        Collection<Tuote> listProducts = tuotteenHallintaService.listAll(hakusana);
        // model.addAttribute("kahvilaitteet", tuoteRepository.findAllKahvilaitteet());
        model.addAttribute("kahvilaitteet", listProducts);
        // model.addAttribute("hakusana", hakusana);
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
