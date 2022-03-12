package com.example.coffeeshop;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TuoteRepository extends JpaRepository<Tuote, Long> {
    
    @Query(
    value = "SELECT * FROM Tuote WHERE Tuote.osasto_id = 1",
    nativeQuery = true)
    Collection<Tuote> findAllKahvilaitteet();
}
