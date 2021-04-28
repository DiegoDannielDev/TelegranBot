package br.com.fourbot.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.fourbot.entities.Chat;

public interface ChatRepository extends CrudRepository<Chat, Long>{

}
