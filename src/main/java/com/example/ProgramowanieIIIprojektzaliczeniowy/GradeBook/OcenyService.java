package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OcenyService {

    @GetMapping
    public List<Oceny> getOceny() {
        return List.of(new Oceny());
    }

}
