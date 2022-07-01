package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UzytkownicyService {

    @GetMapping
    public List<Uzytkownicy> getUzytkownicy() {
        return List.of(new Uzytkownicy());
    }

}
