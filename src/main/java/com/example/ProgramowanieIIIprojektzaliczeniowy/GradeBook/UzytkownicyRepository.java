package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Long> {

    @Query("SELECT u FROM Uzytkownicy u order by u.imie")
    List<Uzytkownicy> findAllSortedByImie();

    @Query("SELECT u FROM Uzytkownicy u order by u.nazwisko")
    List<Uzytkownicy> findAllSortedByNazwisko();

    @Query("SELECT u FROM Uzytkownicy u order by u.rola")
    List<Uzytkownicy> findAllSortedByRola();

    @Query("SELECT u FROM Uzytkownicy u order by u.login")
    List<Uzytkownicy> findAllSortedByLogin();

    @Query("select u FROM Uzytkownicy u WHERE u.login Like '?1'")
    Optional<Uzytkownicy> isLoginTaken(String login);

    @Query("select u FROM Uzytkownicy u WHERE u.haslo Like '?1'")
    List<Uzytkownicy> findByHaslo(String haslo);

    @Query("select u FROM Uzytkownicy u WHERE u.login Like '?1'")
    List<Uzytkownicy> findByLogin(String login);

    @Query("select u FROM Uzytkownicy u WHERE u.imie Like '?1'")
    List<Uzytkownicy> findByImie(String imie);

    @Query("select u FROM Uzytkownicy u WHERE u.nazwisko Like '?1'")
    List<Uzytkownicy> findByNazwisko(String nazwisko);



}