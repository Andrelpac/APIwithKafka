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
		//Cria um Objeto JSON
		JSONObject jsonObject = new JSONObject();

		FileWriter writeFile = null;

		//Armazena dados em um Objeto JSON
		jsonObject.put("messagem", message);

		System.out.println("Mensagem consumida:" + message);
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyyHHmmss");
		String titulo = formatador.format(data);
		try{
			writeFile = new FileWriter("C:\\Users\\andre\\Desktop\\Best2Bee\\Banco\\" + titulo + ".json");
			//Escreve no arquivo conteudo do Objeto JSON
			writeFile.write("["+jsonObject.toString()+"]");
			writeFile.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		//Imprimne na Tela o Objeto JSON para vizualização
		System.out.println(jsonObject);
		System.out.println("Arquivo " + titulo + " criado");
	}
}
