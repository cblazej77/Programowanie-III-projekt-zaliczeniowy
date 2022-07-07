package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class FrekwencjaService {

    private FrekwencjaRepository frekwencjaRepository;

    @Autowired
    public FrekwencjaService(FrekwencjaRepository frekwencjaRepository) {
        this.frekwencjaRepository = frekwencjaRepository;
    }

    @GetMapping
    public List<Frekwencja> getFrekwencja() {
        return frekwencjaRepository.findAll();
    }
}
