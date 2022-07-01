package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UzytkownicyController {
    private final UzytkownicyService uzytkownicyService;

    @Autowired
    public UzytkownicyController(UzytkownicyService uzytkownicyService) {
        this.uzytkownicyService = uzytkownicyService;
    }

    @GetMapping
    public List<Uzytkownicy> getUzytkownicy() {
        return uzytkownicyService.getUzytkownicy();
    }

}
