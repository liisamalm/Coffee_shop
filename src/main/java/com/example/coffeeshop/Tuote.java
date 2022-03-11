package com.example.coffeeshop;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tuote extends AbstractPersistable<Long>{
    private String nimi;
    private String kuvaus;
    private BigDecimal hinta;
    @Lob
    private String tuoteKuva;


    @ManyToOne
    private Toimittaja toimittaja;
    @ManyToOne
    private Valmistaja valmistaja;
    @ManyToOne
    private Osasto osasto;


    
}