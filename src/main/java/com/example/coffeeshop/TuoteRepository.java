package com.example.coffeeshop;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TuoteRepository extends JpaRepository<Tuote, Long> {
    
    @Query(
    value = "SELECT * FROM Tuote WHERE Tuote.osasto_id = 1 OR Tuote.osasto_id = 3 OR Tuote.osasto_id = 4 OR Tuote.osasto_id = 5",
    nativeQuery = true)
    Collection<Tuote> findAllKahvilaitteet();

    @Query(
    value = "SELECT * FROM Tuote WHERE Tuote.osasto_id = 2 OR Tuote.osasto_id = 6 OR Tuote.osasto_id = 7 OR Tuote.osasto_id = 8 OR Tuote.osasto_id = 9",
    nativeQuery = true)
    Collection<Tuote> findAllKulutustuotteet();
}
