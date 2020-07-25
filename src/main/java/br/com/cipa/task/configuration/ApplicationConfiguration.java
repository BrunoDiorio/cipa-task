package br.com.cipa.task.configuration;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {
	
	@SuppressWarnings("deprecation")
	SQSConnectionFactory connectionFactory = SQSConnectionFactory.builder()
			.withRegion(Region.getRegion(Regions.US_EAST_1))
			.withAWSCredentialsProvider(DefaultAWSCredentialsProviderChain.getInstance()).build();
	
	@Bean
	public JmsTemplate defaultJmsTemplate() {
		return new JmsTemplate(this.connectionFactory);
	}

	@Bean
	public RestTemplate restTemplate(final ObjectMapper objectMapper) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate
				.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter((objectMapper))));

		return restTemplate;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper()
				.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
}
