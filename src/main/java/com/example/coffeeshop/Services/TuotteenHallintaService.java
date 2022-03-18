
package com.example.coffeeshop.Services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import com.example.coffeeshop.Tuote;

import com.example.coffeeshop.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
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
        Tuote tuote = new Tuote(nimi, kuvaus, hinta, tuotekuva.getBytes(), toimittaja, valmistaja, osasto);

        tuoteRepository.save(tuote);

    }

    public Tuote findTuote(Long id) {
        Tuote tuote = tuoteRepository.getById(id);
        return tuote;
    }

    @Transactional
    public void deleteOneTuote(Long id) {
        Tuote tuote = tuoteRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        tuoteRepository.delete(tuote);
    }

    public byte[] getTuoteImage(Long id) {
        return tuoteRepository.findById(id).get().getTuotekuva();
    }

    public void updateTuote(Long id, String nimi, String kuvaus, BigDecimal hinta, MultipartFile tuotekuva) throws IOException {
        Tuote tuote = tuoteRepository.getById(id);
        tuote.setNimi(nimi);
        tuote.setHinta(hinta);
        tuote.setKuvaus(kuvaus);
        if(tuotekuva.getBytes() != null) {
            tuote.setTuotekuva(tuotekuva.getBytes());
        }
        tuoteRepository.save(tuote);

    }

    public List<Tuote> listAllKahvilaitteetHakusanalla(String hakusana) {
        
        if (hakusana != null) {
            hakusana = hakusana.toLowerCase();
            return tuoteRepository.findMachineWithSearchIgnoreCase(hakusana);
        }
        return tuoteRepository.findAllKahvilaitteet();
    }

    public List<Tuote> listAllKulutustuotteetHakusanalla(String hakusana) {
        
        if (hakusana != null) {
            hakusana = hakusana.toLowerCase();
            return tuoteRepository.findProductWithSearchIgnoreCase(hakusana);
        }
        return tuoteRepository.findAllKulutustuotteet();
    }

    
    
}
