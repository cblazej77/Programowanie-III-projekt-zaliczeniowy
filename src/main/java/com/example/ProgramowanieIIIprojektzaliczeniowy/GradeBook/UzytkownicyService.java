package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Uzytkownicy> getUzytkownicy() {
        return uzytkownicyRepository.findAll();
    }

}
