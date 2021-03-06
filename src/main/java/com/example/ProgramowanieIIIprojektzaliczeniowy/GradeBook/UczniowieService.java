package com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UczniowieService {

    private UczniowieRepository uczniowieRepository;

    @Autowired
    public UczniowieService(UczniowieRepository uczniowieRepository) {
        this.uczniowieRepository = uczniowieRepository;
    }

    public List<Uczniowie> getUczniowie() {
        return uczniowieRepository.findAll();
    }

    public List<Uczniowie> getUczniowieByImie(String imie) {
        return uczniowieRepository.findByImie(imie);
    }

    public List<Uczniowie> getUczniowieByNazwisko(String nazwisko) {
        return uczniowieRepository.findByNazwisko(nazwisko);
    }

    public List<Uczniowie> getUczniowieByNrwDzienniku(Integer nrwDzienniku) {
        return uczniowieRepository.findByNrwdzienniku(nrwDzienniku);
    }

}
