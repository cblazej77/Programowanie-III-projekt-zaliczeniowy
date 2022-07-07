package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PrzedmiotyService {

    private PrzedmiotyRepository przedmiotyRepository;

    @Autowired
    public PrzedmiotyService(PrzedmiotyRepository przedmiotyRepository) {
        this.przedmiotyRepository = przedmiotyRepository;
    }

    @GetMapping
    public List<Przedmioty> getPrzedmioty() {
        return przedmiotyRepository.findAll();
    }
}
