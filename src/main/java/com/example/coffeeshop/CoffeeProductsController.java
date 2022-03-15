package com.example.coffeeshop;

import java.util.Collection;
import java.util.List;

import com.example.coffeeshop.Services.TuotteenHallintaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoffeeProductsController {

    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    @GetMapping("/kulutustuotteet")
    public String machines(Model model, @Param ("hakusana") String hakusana) {
        // Collection<Tuote> listProducts = tuotteenHallintaService.listAll(hakusana);
        model.addAttribute("kulutustuotteet", tuoteRepository.findAllKulutustuotteet());
        // model.addAttribute("kulutustuotteet", listProducts);
        model.addAttribute("hakusana", hakusana);
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
