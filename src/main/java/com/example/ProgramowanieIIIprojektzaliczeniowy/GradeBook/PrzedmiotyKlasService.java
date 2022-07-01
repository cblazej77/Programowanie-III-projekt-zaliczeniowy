package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PrzedmiotyKlasService {

    @GetMapping
    public List<PrzedmiotyKlas> getPrzedmiotyKlas() {
        return List.of(new PrzedmiotyKlas());
    }

}
