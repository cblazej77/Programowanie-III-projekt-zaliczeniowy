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

    @GetMapping
    public List<Uzytkownicy> getUzytkownicy() {
        return uzytkownicyService.getUzytkownicy();
    }

}
