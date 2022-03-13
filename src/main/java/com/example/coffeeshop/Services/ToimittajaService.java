package com.example.coffeeshop.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
     
    public void updateToimittaja(Long id, String nimi, String yhteyshenkilo, String yhteyshenkilonEmail) {
        Toimittaja toimittaja = toimittajaRepository.getById(id);
        toimittaja.setNimi(nimi);
        toimittaja.setYhteyshenkilo(yhteyshenkilo);
        toimittaja.setYhteyshenkilonEmail(yhteyshenkilonEmail);
        toimittajaRepository.save(toimittaja);
    }

    @Transactional
    public void deleteOneToimittaja(Long toimittajaID) {
        Toimittaja toimittaja = toimittajaRepository.findById(toimittajaID)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + toimittajaID));
        toimittajaRepository.delete(toimittaja);
    }

    public Toimittaja findToimittaja(Long id) {
        Toimittaja toimittaja = toimittajaRepository.getById(id);
        return toimittaja;
    }

}
