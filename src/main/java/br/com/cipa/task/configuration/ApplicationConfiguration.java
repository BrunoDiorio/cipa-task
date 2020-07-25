package br.com.cipa.task.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

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
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
