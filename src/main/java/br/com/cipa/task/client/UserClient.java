package br.com.cipa.task.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cipa.task.entity.Users;

@Component
public class UserClient {
	
    private final RestTemplate restTemplate;
    private final String saveUri;

	public UserClient(final RestTemplate restTemplate,
			@Value("${zendesk.save}") final String saveUri) {
		super();
		this.restTemplate = restTemplate;
		this.saveUri = saveUri;
	}
    
    
    //TODO,
    //endpoint zendesk, modelo de request/response
	private void post(final Users users) {
		restTemplate.postForEntity(this.saveUri, users, Object.class);
	}
}
