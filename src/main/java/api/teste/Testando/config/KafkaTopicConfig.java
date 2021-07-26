package api.teste.Testando.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("reflectoring-1").build();
	}
	
	@Bean
	public NewTopic topic2() {
		return TopicBuilder.name("reflectoring-2").build();
	}
	
	@Value("${app.output-kafka-topic-company}")
	private String outputKafkaTopicCompany;
}

