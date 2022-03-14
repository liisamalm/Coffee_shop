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
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private OsastoRepository osastoRepository;

    @Autowired
    private ToimittajaRepository toimittajaRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    @GetMapping
    public String home() {
        return "index";
    }
   
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

    @GetMapping("/kahvilaite/{id}")
    public String showOneKahvilaite() {
        return "kahvilaite";
    }

    // @GetMapping("/kulutustuotteet")
    // public String products() {
    //     return "kulutustuotteet";
    // }

    @GetMapping("/tuotteenhallinta")
    public String productMaintenance() {
        return "tuotteenhallinta";
    }

   
}

    






