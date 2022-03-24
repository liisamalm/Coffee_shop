package com.example.coffeeshop;

import java.util.List;
import com.example.coffeeshop.Services.TuotteenHallintaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeProductsController {

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    // Näyttää kulutustuotteet sivulla, hakusanan perusteella
    @GetMapping(path= {"/kulutustuotteet", "/searchProducts"})
    public String products(Model model, @Param ("hakusana") String hakusana) {
        List<Tuote> listProducts = tuotteenHallintaService.listAllKulutustuotteetHakusanalla(hakusana);
        model.addAttribute("kulutustuotteet", listProducts);
        return "kulutustuotteet";
    }

    // Hakee tuotteen kuvan ja näyttää sen kulutustuote-sivulla
    @ResponseBody
    @GetMapping("/kulutustuote/tuoteKuva/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

    // Näyttää yhden tuotteen tiedot id:n perusteella ja ohjaa kulutustuotesivulle
    @GetMapping("/kulutustuotteet/{id}")
    public String showOneKulutustuote(Model model, @PathVariable Long id) {
        model.addAttribute("kulutustuote", tuotteenHallintaService.findTuote(id));
        return "kulutustuote";
    }
}
