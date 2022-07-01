package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class FrekwencjaService {

    @GetMapping
    public List<Frekwencja> getFrekwencja() {
        return List.of(new Frekwencja());
    }
}
