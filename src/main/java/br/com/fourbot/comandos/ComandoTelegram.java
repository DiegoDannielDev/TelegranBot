package br.com.fourbot.comandos;

import com.pengrad.telegrambot.model.Update;

public interface ComandoTelegram {

	void executar(Update update); 
}
