package api.teste.Testando.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import api.teste.Testando.config.KafkaConfig;


	@Service
	public class KafkaPublisherService {
		
		@Autowired
		private KafkaTemplate<String, String> kafkaTemplate;

		private static final Logger LOG=LoggerFactory.getLogger(KafkaPublisherService.class);
		
		@Autowired
		 private KafkaConfig appConfig;
	   
		
		public void publish(String string) {
			LOG.info("Sending '{}' to topic = '{}' ",string,appConfig.getOutputKafkaTopic());
			Message<String> message=MessageBuilder.withPayload(string).setHeader(KafkaHeaders.TOPIC, appConfig.getOutputKafkaTopic()).build();
			kafkaTemplate.send(message);
		}
		
}
