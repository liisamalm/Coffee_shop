package com.example.coffeeshop.controller;

import java.io.IOException;
import java.math.BigDecimal;

import com.example.coffeeshop.Services.OsastoService;
import com.example.coffeeshop.Services.ToimittajaService;
import com.example.coffeeshop.Services.TuotteenHallintaService;
import com.example.coffeeshop.Services.ValmistajaService;
import com.example.coffeeshop.model.Osasto;
import com.example.coffeeshop.model.Toimittaja;
import com.example.coffeeshop.model.Valmistaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // Hakee kannasta tietoja tuotteen lisäämistä varten
    @GetMapping("/tuotteen-muokkaus")
    public String editProduct(Model model) {
        model.addAttribute("tuotteet", tuotteenHallintaService.getAllProducts());
        model.addAttribute("osastot", osastoService.getAllOsastot());
        model.addAttribute("toimittajat", toimittajaService.getAllToimittajat());
        model.addAttribute("valmistajat", valmistajaService.getAllValmistajat());
        return "tuotteen-muokkaus";
    }    

    // Lisää tietokantaan uuden tuotteen
    @Secured("ADMIN")
    @PostMapping("/tuotteen-muokkaus")
    public String lisaaTuote(@RequestParam String nimi, @RequestParam String kuvaus, @RequestParam BigDecimal hinta, @RequestParam("tuotekuva") MultipartFile tuotekuva, @RequestParam Toimittaja toimittaja, @RequestParam Valmistaja valmistaja, @RequestParam Osasto osasto) throws IOException {
        tuotteenHallintaService.addTuote(nimi, kuvaus, hinta, tuotekuva, toimittaja, valmistaja, osasto);
        return "redirect:/tuotteen-muokkaus";
    }

    // Näyttää tuotteen luettelossa ja valitessa siirtyy tuote-sivulle
    @GetMapping("/tuotteen-muokkaus/{id}")
    public String showTuote(@RequestParam Long id) {
        tuotteenHallintaService.findTuote(id);
        return "redirect:/tuote/" + id;
    }

    // Näyttää id:n perusteella yhden tuotteen tiedot tuote-sivulla 
    @GetMapping("/tuote/{id}")
    public String showOneTuote(@PathVariable Long id, Model model) {
        model.addAttribute("tuote", tuotteenHallintaService.findTuote(id));
        return "tuote";
    }

    // Poistaa tuotteen tietokannasta
    @GetMapping("/deleteTuote/{id}")
    public String deleteTuote(@PathVariable("id") long id, Model model) {
    tuotteenHallintaService.deleteOneTuote(id);
    return "redirect:/tuotteen-muokkaus";
    }

    // Hakee tuotteen kuvan
    @ResponseBody
    @GetMapping("/tuote/image/{id}")
    public byte[] getImage(@PathVariable Long id) {
        return tuotteenHallintaService.getTuoteImage(id);
    }

    // Päivittää tuotteen tiedot
    @Secured("ADMIN")
    @PostMapping("/updateTuote/{id}")
    public String updateTuote(@PathVariable("id") Long id, @RequestParam String nimi, @RequestParam String kuvaus, @RequestParam BigDecimal hinta, @RequestParam("tuotekuva") MultipartFile tuotekuva) throws IOException {
        tuotteenHallintaService.updateTuote(id, nimi, kuvaus, hinta, tuotekuva);
        return "redirect:/tuotteen-muokkaus";
    }

}
