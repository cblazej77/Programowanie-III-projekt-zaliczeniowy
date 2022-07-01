package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class NauczycieleController {

    private final NauczycieleService nauczycieleService;

    @Autowired
    public NauczycieleController(NauczycieleService nauczycieleService) {
        this.nauczycieleService = nauczycieleService;
    }


    @GetMapping
    public List<Nauczyciele> getNauczyciele() {
        return nauczycieleService.getNauczyciele();
    }

}
