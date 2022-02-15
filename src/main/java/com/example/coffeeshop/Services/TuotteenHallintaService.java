
package com.example.coffeeshop.Services;

import java.util.List;
import java.util.UUID;
import com.example.coffeeshop.Tuote;

import com.example.coffeeshop.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuotteenHallintaService {
    
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @Autowired
    private ToimittajaRepository toimittajaRepository;

    @Autowired
    private OsastoRepository osastoRepository;


    public List<Tuote> getAllProducts() {
        return tuoteRepository.findAll();
    }

    public Tuote addTuote(Tuote tuote) {

        return tuoteRepository.save(tuote);

    }
    
}
