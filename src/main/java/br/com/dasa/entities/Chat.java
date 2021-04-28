package br.com.dasa.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("Chat")
public class Chat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	public Chat() {
		
	}
	
	public Chat(Long id) {
		this.id = id; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
}
