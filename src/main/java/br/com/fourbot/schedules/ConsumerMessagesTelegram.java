package br.com.fourbot.schedules;

import br.com.fourbot.services.TelegramService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConsumerMessagesTelegram {


    private final TelegramService telegramService;

    private final TelegramBot bot;

    public ConsumerMessagesTelegram(TelegramService telegramService, TelegramBot bot) {
        this.telegramService = telegramService;
        this.bot = bot;
    }

    @PostConstruct
    public void buscarMensagens() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(u -> telegramService.processarMensagem(u));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

}
