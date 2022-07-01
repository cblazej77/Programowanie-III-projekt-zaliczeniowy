package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UczniowieService {

    @GetMapping
    public List<Uczniowie> getUczniowie() {
        return List.of(new Uczniowie());
    }

}
