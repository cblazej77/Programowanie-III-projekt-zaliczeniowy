package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/oceny")
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
