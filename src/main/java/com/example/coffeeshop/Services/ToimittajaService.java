package com.example.coffeeshop.Services;

import java.util.List;
import java.util.Optional;

import com.example.coffeeshop.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
public class ToimittajaService {
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @Autowired
    private ToimittajaRepository toimittajaRepository;

    @Autowired
    private OsastoRepository osastoRepository;


    public List<Toimittaja> getAllToimittajat() {
        return toimittajaRepository.findAll();
    }

    //lisää uuden toimittajan tietokantaan
    
    public void addToimittaja(@ModelAttribute Toimittaja toimittaja) {
        toimittajaRepository.save(toimittaja);
    }
     
    public Optional<Toimittaja> findToimittaja(Long id) {
        Optional<Toimittaja> toimittaja = toimittajaRepository.findById(id);
        return toimittaja;
    }

    public void updateToimittaja(){

    }

}


/* public void addToimittaja(String nimi, String yhteyshenkilo, String yhteyshenkilonEmail) {
        Toimittaja toimittaja = new Toimittaja();
        toimittaja.setNimi(nimi);
        toimittaja.setYhteyshenkilo(yhteyshenkilo);
        toimittaja.setYhteyshenkilonEmail(yhteyshenkilonEmail);
        toimittajaRepository.save(toimittaja);
    } 
     */