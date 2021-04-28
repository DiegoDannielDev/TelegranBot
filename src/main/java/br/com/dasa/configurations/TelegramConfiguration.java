package br.com.dasa.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pengrad.telegrambot.TelegramBot;

@Configuration
public class TelegramConfiguration {

	@Value("${token.telegram}")
	private String token; 
	
	@Bean
	public TelegramBot getTelegramBot() {
		return new TelegramBot(token); 
	}
	
}
