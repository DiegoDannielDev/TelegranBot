package br.com.fourbot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbot.controllers.jsons.NotificacaoJson;
import br.com.fourbot.entities.Chat;
import br.com.fourbot.repositories.ChatRepository;

@Service
public class NotificacaoService {

	@Autowired
	private ChatRepository chatRepository; 
	@Autowired
	private TelegramService telegramService;

	public void notificar(NotificacaoJson json) {
		Iterable<Chat> itarable = chatRepository.findAll();
		itarable.forEach(c -> telegramService.sendMessage(c.getId(), json.getMsg()));
	} 
}
