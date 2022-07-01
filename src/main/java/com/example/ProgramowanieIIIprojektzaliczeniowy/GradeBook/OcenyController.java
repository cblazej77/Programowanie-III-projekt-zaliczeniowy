package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class OcenyController {

    private final OcenyService ocenyService;

    @Autowired
    public OcenyController(OcenyService ocenyService) {
        this.ocenyService = ocenyService;
    }

    @GetMapping
    public List<Oceny> getOceny() {
        return ocenyService.getOceny();
    }

}
