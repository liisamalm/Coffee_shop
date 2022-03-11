
package com.example.coffeeshop.Services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import com.example.coffeeshop.Tuote;

import com.example.coffeeshop.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

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

    public void addTuote(String nimi, String kuvaus, BigDecimal hinta, MultipartFile tuotekuva, Toimittaja toimittaja, Valmistaja valmistaja, Osasto osasto) throws IOException {
        Tuote tuote = new Tuote(nimi, kuvaus, hinta, Base64.getEncoder().encodeToString(tuotekuva.getBytes()), toimittaja, valmistaja, osasto);

        tuoteRepository.save(tuote);

    }

    public Tuote findTuote(Long id) {
        Tuote tuote = tuoteRepository.getById(id);
        return tuote;
    }
    
}
