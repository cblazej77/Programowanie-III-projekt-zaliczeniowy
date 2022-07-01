package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class KlasyController {

    private final KlasyService klasyService;

    @Autowired
    public KlasyController(KlasyService klasyService) {
        this.klasyService = klasyService;
    }


    @GetMapping
    public List<Klasy> getKlasy() {
        return klasyService.getKlasy();
    }

}
