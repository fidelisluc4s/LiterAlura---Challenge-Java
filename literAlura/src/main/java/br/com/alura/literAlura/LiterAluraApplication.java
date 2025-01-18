package br.com.alura.literAlura;

import br.com.alura.literAlura.model.DataBook;
import br.com.alura.literAlura.service.ConsumerAPI;
import br.com.alura.literAlura.service.ResponseAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ola");
		
	}
}
