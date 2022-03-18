package com.example.coffeeshop;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

public interface TuoteRepository extends JpaRepository<Tuote, Long> {
    
    @Query(
    value = "SELECT TOP 18 * FROM Tuote WHERE Tuote.osasto_id = 1 OR Tuote.osasto_id = 3 OR Tuote.osasto_id = 4 OR Tuote.osasto_id = 5",
    nativeQuery = true)
    List<Tuote> findAllKahvilaitteet();

    @Query(
    value = "SELECT TOP 18 * FROM Tuote WHERE Tuote.osasto_id = 2 OR Tuote.osasto_id > 5",
    nativeQuery = true)
    List<Tuote> findAllKulutustuotteet();

    @Query(
    value = "SELECT * FROM Tuote t WHERE lower(t.nimi) LIKE %:hakusana% AND t.osasto_id <> 2 AND t.osasto_id <= 5",
    nativeQuery = true)
    List<Tuote> findMachineWithSearchIgnoreCase(@Param("hakusana") String hakusana);

    @Query(
    value = "SELECT * FROM Tuote t WHERE (lower(t.nimi) LIKE %:hakusana% AND t.osasto_id > 5) OR (lower(t.nimi) LIKE %:hakusana% AND t.osasto_id = 2)",
    nativeQuery = true)
    List<Tuote> findProductWithSearchIgnoreCase(@Param("hakusana") String hakusana);

}
