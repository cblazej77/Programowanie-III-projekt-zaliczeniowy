package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/uczniowie")
public class UczniowieController {

    private final UczniowieService uczniowieService;

    @Autowired
    public UczniowieController(UczniowieService uczniowieService) {
        this.uczniowieService = uczniowieService;
    }

    @GetMapping
    public List<Uczniowie> getUczniowie() {
        return uczniowieService.getUczniowie();
    }

}
