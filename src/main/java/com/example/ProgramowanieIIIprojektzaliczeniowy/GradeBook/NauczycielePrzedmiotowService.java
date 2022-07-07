package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NauczycielePrzedmiotowService {

    private NauczycielePrzedmiotowRepository nauczycielePrzedmiotowRepository;

    @Autowired
    public NauczycielePrzedmiotowService(NauczycielePrzedmiotowRepository nauczycielePrzedmiotowRepository) {
        this.nauczycielePrzedmiotowRepository = nauczycielePrzedmiotowRepository;
    }

    @GetMapping
    public List<NauczycielePrzedmiotow> getNauczycielePrzedmiotow() {
        return nauczycielePrzedmiotowRepository.findAll();
    }

}
