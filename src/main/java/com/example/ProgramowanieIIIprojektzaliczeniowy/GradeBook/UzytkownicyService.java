package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UzytkownicyService {

    private UzytkownicyRepository uzytkownicyRepository;

    @Autowired
    public UzytkownicyService(UzytkownicyRepository uzytkownicyRepository) {
        this.uzytkownicyRepository = uzytkownicyRepository;
    }


    public List<Uzytkownicy> getUzytkownicy() {
        return uzytkownicyRepository.findAll();
    }


    public List<Uzytkownicy> getUzytkownicySortedByImie() {
        return uzytkownicyRepository.findAllSortedByImie();
    }


    public List<Uzytkownicy> getUzytkownicySortedByNazwisko() {
        return uzytkownicyRepository.findAllSortedByNazwisko();
    }


    public List<Uzytkownicy> getUzytkownicySortedByRola() {
        return uzytkownicyRepository.findAllSortedByRola();
    }


    public List<Uzytkownicy> getUzytkownicySortedByLogin() {
        return uzytkownicyRepository.findAllSortedByLogin();
    }


    public List<Uzytkownicy> getUzytkownicyByImie(String imie) {
        return uzytkownicyRepository.findByImie(imie);
    }


    public List<Uzytkownicy> getUzytkownicyByNazwisko(String nazwisko) {
        return uzytkownicyRepository.findByNazwisko(nazwisko);
    }


    public List<Uzytkownicy> getUzytkownicyByHaslo(String haslo) {
        return uzytkownicyRepository.findByHaslo(haslo);
    }


    public List<Uzytkownicy> getUzytkownicyByLogin(String login) {
        return uzytkownicyRepository.findByLogin(login);
    }

}
