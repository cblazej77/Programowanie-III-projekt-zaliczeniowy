package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/nauczycieleprzedmiotow")
public class NauczycielePrzedmiotowController {

    private final NauczycielePrzedmiotowService nauczycielePrzedmiotowService;

    @Autowired
    public NauczycielePrzedmiotowController(NauczycielePrzedmiotowService nauczycielePrzedmiotowService) {
        this.nauczycielePrzedmiotowService = nauczycielePrzedmiotowService;
    }

    @GetMapping
    public List<NauczycielePrzedmiotow> getNauczycielePrzedmiotow() {
        return nauczycielePrzedmiotowService.getNauczycielePrzedmiotow();
    }

}
