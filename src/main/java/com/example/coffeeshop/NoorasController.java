package com.example.coffeeshop;

import java.io.IOException;
import java.math.BigDecimal;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    // @PostMapping("/tuotteen-muokkaus")
    // public ResponseEntity<Tuote> addTuote(@RequestBody Tuote tuote) {

    //     Tuote uusiTuote = tuotteenHallintaService.addTuote(tuote);

    //     return new ResponseEntity<>(uusiTuote, HttpStatus.CREATED);

    

    @PostMapping("/tuotteen-muokkaus")
    public String lisaaTuote(@RequestParam String nimi, @RequestParam String kuvaus, @RequestParam BigDecimal hinta, @RequestParam("tuotekuva") MultipartFile tuotekuva, @RequestParam Toimittaja toimittaja, @RequestParam Valmistaja valmistaja, @RequestParam Osasto osasto) throws IOException {
        tuotteenHallintaService.addTuote(nimi, kuvaus, hinta, tuotekuva, toimittaja, valmistaja, osasto);
        return "redirect:/tuotteen-muokkaus";
    }

    @GetMapping("/tuotteen-muokkaus/{id}")
    public String showValmistaja(@RequestParam Long id, Model model) {
        tuotteenHallintaService.findTuote(id);
        return "redirect:/tuote/" + id;
    }

    // Näyttää id:n perusteella yhden tuotteen tiedot tuote-sivulla 
    @GetMapping("/tuote/{id}")
    public String showOneTuote(@PathVariable Long id, Model model) {
        model.addAttribute("tuote", tuotteenHallintaService.findTuote(id));
        return "tuote";
    }

// Uloskirjautuminen 




}
