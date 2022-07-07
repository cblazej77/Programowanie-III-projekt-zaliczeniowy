package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/frekwencja")
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
