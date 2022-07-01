package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UczniowieController {

    private final UczniowieController uczniowieController;

    @Autowired
    public UczniowieController(UczniowieController uczniowieController) {
        this.uczniowieController = uczniowieController;
    }

    @GetMapping
    public List<Uczniowie> getUczniowie() {
        return uczniowieController.getUczniowie();
    }

}
