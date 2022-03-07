package com.example.coffeeshop;

import java.util.Optional;

import com.example.coffeeshop.Services.ToimittajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/upateToimittaja/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<Toimittaja> toimittaja = toimittajaService.findToimittaja(id);
        model.addAttribute("toimittaja", toimittaja);
   
        return "updateToimittaja";
    
    }

 
}

/* @PostMapping("/toimittajan-muokkaus")
    public String addToimittaja(@RequestParam String nimi, 
                                @RequestParam String yhteyshenkilo, 
                                @RequestParam String yhteyshenkilonEmail) {
       toimittajaService.addToimittaja(nimi,yhteyshenkilo,yhteyshenkilonEmail);
        return "redirect:/toimittajan-muokkaus";
    }  */

