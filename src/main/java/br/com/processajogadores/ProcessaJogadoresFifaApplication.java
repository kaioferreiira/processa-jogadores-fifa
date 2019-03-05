package br.com.processajogadores;

import br.com.processajogadores.Service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessaJogadoresFifaApplication  implements CommandLineRunner {

	@Autowired
	private JogadorService jogadorService;

	public static void main(String[] args) {
		SpringApplication.run(ProcessaJogadoresFifaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		jogadorService.processarFileJogador();
	}
}
