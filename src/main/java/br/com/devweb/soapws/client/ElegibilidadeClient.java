
package br.com.devweb.soapws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import br.com.devweb.soapws.model.ClienteRequest;
import br.com.devweb.soapws.model.Situacao;

@Service
public class ElegibilidadeClient extends WebServiceGatewaySupport {

	private static final Logger LOG = LoggerFactory.getLogger(ElegibilidadeClient.class);

	@Autowired
	private Jaxb2Marshaller marshaller;

	public Situacao getSituacao(ClienteRequest request) {

		LOG.info("Situação elegibilidade Emprestimo");
		WebServiceTemplate template = new WebServiceTemplate(marshaller);

		return (Situacao) template.marshalSendAndReceive("http://localhost:8090/ws", request);
	}

}
