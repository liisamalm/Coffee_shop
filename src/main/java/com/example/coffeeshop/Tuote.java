package com.example.coffeeshop;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Entity;

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
    private Blob tuotekuva;

    
}