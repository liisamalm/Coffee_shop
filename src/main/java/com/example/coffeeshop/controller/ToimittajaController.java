package com.example.coffeeshop.controller;

import com.example.coffeeshop.Services.ToimittajaService;
import com.example.coffeeshop.model.Toimittaja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToimittajaController {

    @Autowired
    private ToimittajaService toimittajaService;

   

 //get tyyppinen pyyntö listaa kaikki tietokannassa olevat toimittajat (kuuntelee pyytöjä osoitteeseen toimittajan-muokkaus)
    @GetMapping("/toimittajan-muokkaus")
    public String listToimittajat(Model model) {
        model.addAttribute("toimittajat", toimittajaService.getAllToimittajat());
        return "toimittajan-muokkaus";
    }

//post tyyppinen pyyntö polkuun /toimittajan-muokkaus lisää toimittajan tietokantaan
     @PostMapping("/toimittajan-muokkaus")
     public String addToimittaja(@ModelAttribute Toimittaja toimittaja){
         toimittajaService.addToimittaja(toimittaja);
         return "redirect:/toimittajan-muokkaus";

     }

// kuuntelee pyyntöjä osoitteeseen /toimittajan-muokkaus, jota seuraa toimittajan tunnuksen määrittelevä polkumuuttuja
    @GetMapping("/toimittajan-muokkaus/{id}")
    public String showToimittaja(@RequestParam Long id, Model model) {
        toimittajaService.findToimittaja(id);
        return "redirect:/toimittaja/" + id;
    }

 //get tyyppinen pyyntö polkuun /toimittaja/{id} hakee ja näyttää tietyn toimittajan tiedot
    @GetMapping("/toimittaja/{id}")
    public String showOneToimittaja(@PathVariable Long id, Model model) {
        model.addAttribute("toimittaja", toimittajaService.findToimittaja(id));
        return "toimittaja";
    }

    // Poistaa toimittajan tietokannasta
    @GetMapping("/deleteToimittaja/{id}")
    public String deleteToimittaja(@PathVariable("id") long id, Model model) {
    toimittajaService.deleteOneToimittaja(id);
    return "redirect:/toimittajan-muokkaus";
    }

    // Päivittää toimittajan tiedot
    @PostMapping("/updateToimittaja/{id}")
    public String updateToimittaja(@PathVariable("id") Long id, @RequestParam String nimi, @RequestParam String yhteyshenkilo, String yhteyshenkilonEmail) {
        toimittajaService.updateToimittaja(id, nimi, yhteyshenkilo, yhteyshenkilonEmail);
        return "redirect:/toimittajan-muokkaus";
    }
}


