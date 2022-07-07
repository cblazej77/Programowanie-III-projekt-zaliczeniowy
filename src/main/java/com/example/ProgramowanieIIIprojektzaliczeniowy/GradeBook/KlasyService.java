package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class KlasyService {

    private KlasyRepository klasyRepository;

    @Autowired
    public KlasyService(KlasyRepository klasyRepository) {
        this.klasyRepository = klasyRepository;
    }

    @GetMapping
    public List<Klasy> getKlasy() {
        return klasyRepository.findAll();
    }
}
