package com.example.coffeeshop.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.coffeeshop.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValmistajaService {
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @Autowired
    private ToimittajaRepository toimittajaRepository;

    @Autowired
    private OsastoRepository osastoRepository;


    public List<Valmistaja> getAllValmistajat() {
        return valmistajaRepository.findAll();
    }

    public void addValmistaja(String nimi, String url) {
        Valmistaja valmistaja = new Valmistaja();
        valmistaja.setNimi(nimi);
        valmistaja.setUrl(url);
        valmistajaRepository.save(valmistaja);
    }

    public void updateValmistaja() {

    }

    public void deleteValmistaja(Long valmistajaID) {
        Valmistaja valmistaja = valmistajaRepository.findById(valmistajaID)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + valmistajaID));
    valmistajaRepository.delete(valmistaja);
    }

    public Optional<Valmistaja> findValmistaja(Long id) {
        Optional<Valmistaja> valmistaja = valmistajaRepository.findById(id);
        return valmistaja;
    }

    



}
