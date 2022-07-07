package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/przedmioty")
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
