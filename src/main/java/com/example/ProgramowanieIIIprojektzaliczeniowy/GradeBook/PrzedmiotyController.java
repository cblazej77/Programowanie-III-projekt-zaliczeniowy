package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PrzedmiotyController {

    private final PrzedmiotyService przedmiotyService;

    @Autowired
    public PrzedmiotyController(PrzedmiotyService przedmiotyService) {
        this.przedmiotyService = przedmiotyService;
    }

    @GetMapping
    public List<Przedmioty> getPrzedmioty() {
        return przedmiotyService.getPrzedmioty();
    }

}
