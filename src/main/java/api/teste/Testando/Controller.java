package api.teste.Testando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.teste.Testando.service.KafkaPublisherService;

@RestController
@RequestMapping("/teste")
public class Controller {

	@Autowired
	KafkaPublisherService service;
	
	@PostMapping
	public void send() {
		service.publish("Oi Lilica");
	}
}
