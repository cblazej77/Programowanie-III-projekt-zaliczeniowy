package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class OcenyService {

    private OcenyRepository ocenyRepository;

    @Autowired
    public OcenyService(OcenyRepository ocenyRepository) {
        this.ocenyRepository = ocenyRepository;
    }

    @GetMapping
    public List<Oceny> getOceny() {
        return ocenyRepository.findAll();
    }

}
