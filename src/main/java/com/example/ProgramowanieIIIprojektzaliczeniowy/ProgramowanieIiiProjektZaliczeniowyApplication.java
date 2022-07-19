package com.example.ProgramowanieIIIprojektzaliczeniowy;

import com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook.Uzytkownicy;
import com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook.UzytkownicyRepository;
import com.example.ProgramowanieIIIprojektzaliczeniowy.GradeBook.UzytkownicyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.beans.BeanProperty;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
@RestController
public class ProgramowanieIiiProjektZaliczeniowyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramowanieIiiProjektZaliczeniowyApplication.class, args);

		/*
		try {
			ServerSocket server = new ServerSocket(8081);
			while (true) {
				Socket socket = server.accept();
				ThreadForClient thc = new ThreadForClient(socket);
				thc.start();

			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		*/
	}
	@Bean
	public CommandLineRunner run(UzytkownicyRepository repository){
		return (args -> {
			//insertJavaAdvocates(repository);
			System.out.println(repository.findAll());
		});
	}
	/*
	private void insertJavaAdvocates(UzytkownicyRepository repository){
		repository.save(new Uzytkownicy("KD004", "haslo", "Michal", "Dupi", "RODZIC"));
	}
	*/
}


