package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/nauczyciele")
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
