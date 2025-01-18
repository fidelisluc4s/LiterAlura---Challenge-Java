package br.com.alura.literAlura;

import br.com.alura.literAlura.model.DataBook;
import br.com.alura.literAlura.service.ConsumerAPI;
import br.com.alura.literAlura.service.ResponseAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "https://gutendex.com/books/?search=shakespeare";

		ConsumerAPI consumerAPI = new ConsumerAPI();

		String jsonResponse = consumerAPI.obterDados(url);
		System.out.println("Resposta da API: ");
		System.out.println(jsonResponse);

		ObjectMapper objectMapper = new ObjectMapper();

		ResponseAPI responseAPI = objectMapper.readValue(jsonResponse, ResponseAPI.class);

		System.out.println("Total de livros encontrados: " + responseAPI.getCount());
		for (DataBook book : responseAPI.getResults()) {
			System.out.println(book);
		}
	}
}
