package br.com.dasa.comandos;

import com.pengrad.telegrambot.model.Update;

public interface ComandoTelegram {

	void executar(Update update); 
}
