package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/uzytkownicy")
public class UzytkownicyController {
    private final UzytkownicyService uzytkownicyService;

    @Autowired
    public UzytkownicyController(UzytkownicyService uzytkownicyService) {
        this.uzytkownicyService = uzytkownicyService;
    }


    public List<Uzytkownicy> getUzytkownicy() {
        return uzytkownicyService.getUzytkownicy();
    }


    public List<Uzytkownicy> getUzytkownicySortedByImie() {
        return uzytkownicyService.getUzytkownicySortedByImie();
    }


    public List<Uzytkownicy> getUzytkownicySortedByNazwisko() {
        return uzytkownicyService.getUzytkownicySortedByNazwisko();
    }


    public List<Uzytkownicy> getUzytkownicySortedByRola() {
        return uzytkownicyService.getUzytkownicySortedByRola();
    }


    public List<Uzytkownicy> getUzytkownicySortedByLogin() {
        return uzytkownicyService.getUzytkownicySortedByLogin();
    }


    public List<Uzytkownicy> getUzytkownicyByImie(String imie) {
        return uzytkownicyService.getUzytkownicyByImie(imie);
    }


    public List<Uzytkownicy> getUzytkownicyByNazwisko(String nazwisko) {
        return uzytkownicyService.getUzytkownicyByNazwisko(nazwisko);
    }


    public List<Uzytkownicy> getUzytkownicyByHaslo(String haslo) {
        return uzytkownicyService.getUzytkownicyByHaslo(haslo);
    }


    public List<Uzytkownicy> getUzytkownicyByLogin(String login) {
        return uzytkownicyService.getUzytkownicyByLogin(login);
    }


}
