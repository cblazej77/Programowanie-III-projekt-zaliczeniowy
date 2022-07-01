package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class KlasyService {

    @GetMapping
    public List<Klasy> getKlasy() {
        return List.of(new Klasy());
    }
}
