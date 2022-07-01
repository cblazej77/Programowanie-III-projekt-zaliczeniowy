package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PrzedmiotyService {

    @GetMapping
    public List<Przedmioty> getPrzedmioty() {
        return List.of(new Przedmioty(1L, "Matematyka"));
    }
}
