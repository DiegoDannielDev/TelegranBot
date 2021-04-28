package br.com.dasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BotNotificacaoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotNotificacaoApiApplication.class, args);
	}

}
