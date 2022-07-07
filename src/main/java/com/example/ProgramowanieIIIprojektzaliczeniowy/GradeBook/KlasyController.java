package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/klasy")
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
