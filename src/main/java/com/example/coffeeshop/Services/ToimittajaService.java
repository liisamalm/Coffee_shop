package com.example.coffeeshop.Services;

import java.util.List;

import com.example.coffeeshop.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


    public void addToimittaja(Toimittaja toimittaja) {
        toimittajaRepository.save(toimittaja);


    }
}
