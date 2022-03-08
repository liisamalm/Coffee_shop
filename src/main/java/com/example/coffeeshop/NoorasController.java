package com.example.coffeeshop;

import com.example.coffeeshop.Services.OsastoService;
import com.example.coffeeshop.Services.ToimittajaService;
import com.example.coffeeshop.Services.TuotteenHallintaService;
import com.example.coffeeshop.Services.ValmistajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NoorasController {

    @Autowired
    private TuotteenHallintaService tuotteenHallintaService;

    @Autowired
    private ValmistajaService valmistajaService;

    @Autowired
    private ToimittajaService toimittajaService;

    @Autowired
    private OsastoService osastoService;

    
    @GetMapping("/tuotteen-muokkaus")
    public String editProduct(Model model) {
        model.addAttribute("tuotteet", tuotteenHallintaService.getAllProducts());
        model.addAttribute("osastot", osastoService.getAllOsastot());
        model.addAttribute("toimittajat", toimittajaService.getAllToimittajat());
        model.addAttribute("valmistajat", valmistajaService.getAllValmistajat());
        return "tuotteen-muokkaus";
    }

    
    // Lisää uusi tuote
    @PostMapping("/tuotteen-muokkaus")
    public ResponseEntity<Tuote> addTuote(@RequestBody Tuote tuote) {

        Tuote uusiTuote = tuotteenHallintaService.addTuote(tuote);

        return new ResponseEntity<>(uusiTuote, HttpStatus.CREATED);

    }

// Uloskirjautuminen 




}
