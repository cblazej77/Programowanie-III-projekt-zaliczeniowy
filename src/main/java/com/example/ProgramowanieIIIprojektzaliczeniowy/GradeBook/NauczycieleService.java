package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NauczycieleService {

    private NauczycieleRepository nauczycieleRepository;

    @Autowired
    public NauczycieleService(NauczycieleRepository nauczycieleRepository) {
        this.nauczycieleRepository = nauczycieleRepository;
    }

    @GetMapping
    public List<Nauczyciele> getNauczyciele() {
        return nauczycieleRepository.findAll();
    }
}
