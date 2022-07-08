package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UczniowieRepository extends JpaRepository<Uczniowie, Long> {

    @Query("SELECT u FROM Uczniowie u JOIN Uzytkownicy uz ON u.iduucznia = uz.idu where uz.imie LIKE '?1'")
    List<Uczniowie> findByImie(String imie);

    @Query("SELECT u FROM Uczniowie u JOIN Uzytkownicy uz ON u.iduucznia = uz.idu where uz.nazwisko LIKE '?1'")
    List<Uczniowie> findByNazwisko(String nazwisko);

    List<Uczniowie> findByNrwdzienniku(Integer nrwdzienniku);


}