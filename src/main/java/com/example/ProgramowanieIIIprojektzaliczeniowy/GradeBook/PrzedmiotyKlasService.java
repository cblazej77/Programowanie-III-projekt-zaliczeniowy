package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PrzedmiotyKlasService {

    private PrzedmiotyKlasRepository przedmiotyKlasRepository;


    @Autowired
    public PrzedmiotyKlasService(PrzedmiotyKlasRepository przedmiotyKlasRepository) {
        this.przedmiotyKlasRepository = przedmiotyKlasRepository;
    }

    @GetMapping
    public List<PrzedmiotyKlas> getPrzedmiotyKlas() {
        return przedmiotyKlasRepository.findAll();
    }

}
