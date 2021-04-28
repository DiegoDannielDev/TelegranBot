package br.com.fourbot.services;

import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.fourbot.comandos.ComandoTelegram;

@Service
public class TelegramService {

	private static final Logger LOG = LoggerFactory.getLogger(TelegramService.class);

	@Autowired
	private TelegramBot bot;
	@Autowired
	private ComandosService comandosService;

	private Map<String, ComandoTelegram> mapaComandos;

	@PostConstruct
	public void iniciar() {
		mapaComandos = comandosService.getMapaComandos();
	}

	public void processarMensagem(Update update) {
		try {
			String comando = update.message().text();
			if ((Objects.nonNull(comando)) && mapaComandos.containsKey(comando.toUpperCase())) {
				ComandoTelegram comandoTelegram = mapaComandos.get(comando.toUpperCase());
				comandoTelegram.executar(update);
			} else {
				StringBuilder msg = new StringBuilder();
				msg.append("Comandos disponíveis: ");
				mapaComandos.keySet().forEach(k -> msg.append("\n").append(k));
				sendMessage(update.message().chat().id(), msg.toString());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

	}

	public void sendMessage(Long chatId, String msg) {
		bot.execute(new SendMessage(chatId, msg));
	}

}
