package br.com.dasa.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dasa.comandos.ComandoAssinar;
import br.com.dasa.comandos.ComandoDesinscrever;
import br.com.dasa.comandos.ComandoTelegram;

@Service
public class ComandosService {

	private HashMap<String, ComandoTelegram> mapaComandos = new HashMap<>();

	@Autowired
	private ComandoAssinar comandoAssinar;
	@Autowired
	private ComandoDesinscrever comandoDesinscrever;

	@PostConstruct
	public void iniciar() {

		mapaComandos.put("/ASSINAR", comandoAssinar);
		mapaComandos.put("/DESINSCREVER", comandoDesinscrever);

	}

	public Map<String, ComandoTelegram> getMapaComandos() {
		return mapaComandos;
	}

}
