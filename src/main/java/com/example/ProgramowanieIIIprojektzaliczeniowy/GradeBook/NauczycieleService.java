package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NauczycieleService {
    @GetMapping
    public List<Nauczyciele> getNauczyciele() {
        return List.of(new Nauczyciele());
    }
}
