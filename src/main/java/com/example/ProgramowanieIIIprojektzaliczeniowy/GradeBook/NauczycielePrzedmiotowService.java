package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NauczycielePrzedmiotowService {

    @GetMapping
    public List<NauczycielePrzedmiotow> getNauczycielePrzedmiotow() {
        return List.of(new NauczycielePrzedmiotow());
    }

}
