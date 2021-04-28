package br.com.dasa.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dasa.entities.Chat;

public interface ChatRepository extends CrudRepository<Chat, Long>{

}
