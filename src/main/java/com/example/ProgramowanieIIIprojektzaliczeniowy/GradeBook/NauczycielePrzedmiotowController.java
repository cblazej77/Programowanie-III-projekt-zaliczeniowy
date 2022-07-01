package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
