package br.com.alura.literAlura;

import br.com.alura.literAlura.controller.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private CommandLine cmdLine;

	public void LiterAluraApplication(CommandLine cmdLine) {
		this.cmdLine = cmdLine;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cmdLine.showMenu();
	}
}
