package br.com.dasa.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.model.Update;

import br.com.dasa.entities.Chat;
import br.com.dasa.repositories.ChatRepository;
import br.com.dasa.services.TelegramService;

@Component
public class ComandoAssinar implements ComandoTelegram {

	@Autowired
	private ChatRepository chatRepository; 
	@Autowired
	private TelegramService telegramService; 
	
	@Override
	public void executar(Update update) {
		Long id = update.message().chat().id();
		if(!chatRepository.existsById(id)) {
			chatRepository.save(new Chat(id));
			telegramService.sendMessage(id, "Chat assinado com sucesso. Mande /DESINSCREVER para sair. ");
			return; 
		}
		
		telegramService.sendMessage(id, "Você já assinou as notificações de erro");
		
	}

}
