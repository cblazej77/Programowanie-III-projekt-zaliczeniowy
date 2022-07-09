package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class UczniowieController {

    private final UczniowieService uczniowieService;

    @Autowired
    public UczniowieController(UczniowieService uczniowieService) {
        this.uczniowieService = uczniowieService;
    }

    @GetMapping(path = "/api/uczniowie")
    public List<Uczniowie> getUczniowie() {
        return uczniowieService.getUczniowie();
    }


    public List<Uczniowie> getUczniowieByImie(String imie) {
        return uczniowieService.getUczniowieByImie(imie);
    }

}
