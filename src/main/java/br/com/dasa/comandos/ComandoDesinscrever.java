package br.com.dasa.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.model.Update;

import br.com.dasa.repositories.ChatRepository;
import br.com.dasa.services.TelegramService;

@Component
public class ComandoDesinscrever implements ComandoTelegram{

	@Autowired
	private TelegramService telegramService; 
	@Autowired
	private ChatRepository chatRepository; 
	
	@Override
	public void executar(Update update) {
		Long id = update.message().chat().id(); 
		
		if(chatRepository.existsById(id)) {
			chatRepository.deleteById(id);
			telegramService.sendMessage(id, "Você está desinscrito");
		}else {
			telegramService.sendMessage(id, "Você não assinou as notificações para poder se desinscrever.");
		}
		
	}

}
