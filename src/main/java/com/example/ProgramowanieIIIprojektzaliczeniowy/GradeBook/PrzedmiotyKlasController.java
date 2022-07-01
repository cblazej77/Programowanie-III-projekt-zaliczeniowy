package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PrzedmiotyKlasController {

    private final PrzedmiotyKlasService przedmiotyKlasService;

    @Autowired
    public PrzedmiotyKlasController(PrzedmiotyKlasService przedmiotyKlasService) {
        this.przedmiotyKlasService = przedmiotyKlasService;
    }

    @GetMapping
    public List<PrzedmiotyKlas> getPrzedmiotyKlas() {
        return przedmiotyKlasService.getPrzedmiotyKlas();
    }

}
