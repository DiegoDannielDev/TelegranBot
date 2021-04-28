package br.com.dasa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dasa.controllers.jsons.NotificacaoJson;
import br.com.dasa.services.NotificacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api para envio de mensagens pelo Telegram")
@RestController
@RequestMapping("/api/notificacao")
public class NotificacaoController {

	@Autowired
	private NotificacaoService notificacaoService; 
	
	@ApiOperation(value = "Envia uma mensagem para o telegram")
	@PostMapping
	public ResponseEntity postarMensagem(@RequestBody  NotificacaoJson json) {
		notificacaoService.notificar(json); 
		return new ResponseEntity(HttpStatus.CREATED); 
		
	}
}
