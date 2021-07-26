package api.teste.Testando.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics = "nome_do_topico", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consumer(String message) throws IOException, JSONException {
		System.out.println(message);
	}
}
