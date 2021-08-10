package br.com.devweb.soapws.api.v1;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.soapws.client.ElegibilidadeClient;
import br.com.devweb.soapws.model.ClienteRequest;
import br.com.devweb.soapws.model.Situacao;

@RestController
@RequestMapping("/v1")
public class ElegibilidadeController {

	@Autowired
	private ElegibilidadeClient client;
	
	@GetMapping("/data-sistema")
	public OffsetDateTime verificarDataSisema() {
		return OffsetDateTime.now();
	}

	@PostMapping("/elegibilidade-emprestimo")
	public Situacao verificarElegibilidade(@RequestBody ClienteRequest request) {
		return client.getSituacao(request);
	}

}
