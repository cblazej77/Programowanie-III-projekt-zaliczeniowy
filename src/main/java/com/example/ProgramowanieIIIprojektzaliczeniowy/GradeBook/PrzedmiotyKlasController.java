package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/przedmiotyklas")
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
