package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class FrekwencjaController {

    private final FrekwencjaService frekwencjaService;

    @Autowired
    public FrekwencjaController(FrekwencjaService frekwencjaService) {
        this.frekwencjaService = frekwencjaService;
    }

    @GetMapping
    public List<Frekwencja> getFrekwencja() {
        return frekwencjaService.getFrekwencja();
    }
}
