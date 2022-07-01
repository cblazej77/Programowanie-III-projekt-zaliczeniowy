package com.example.ProgramowanieIIIprojektzaliczeniowy;

import com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook.Przedmioty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ProgramowanieIiiProjektZaliczeniowyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramowanieIiiProjektZaliczeniowyApplication.class, args);
	}



}
