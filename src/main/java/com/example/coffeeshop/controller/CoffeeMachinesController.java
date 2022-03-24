package com.example.coffeeshop.controller;

import java.util.List;
import com.example.coffeeshop.Services.TuotteenHallintaService;
import com.example.coffeeshop.model.Tuote;

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
    private TuotteenHallintaService tuotteenHallintaService;

    // Näyttää kahvilaitteet-sivulla laitteet, joko kaikki tai hakusanan perusteella
    @GetMapping(path= {"/kahvilaitteet", "/search"})
    public String machines(Model model, @Param("hakusana") String hakusana) {
        List<Tuote> listProducts = tuotteenHallintaService.listAllKahvilaitteetHakusanalla(hakusana);
        model.addAttribute("kahvilaitteet", listProducts);
        return "kahvilaitteet";
    }

    // Hakee tuotteen kuvan tietokannasta
    @ResponseBody
    @GetMapping("/kahvilaite/tuoteKuva/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

    // Näyttää yhden kahvilaitteen tiedot id:n perusteella ja ohjaa kahvilaite-sivulle
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
