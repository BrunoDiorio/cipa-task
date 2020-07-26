package br.com.cipa.task.client;

import br.com.cipa.task.adapter.SaveUsersRequest;
import br.com.cipa.task.dto.UsersDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Service
public class ZendeskClient {
	
    private final RestTemplate restTemplate;
    private final String saveUri;
    private final HttpHeaders httpHeader;

	public ZendeskClient(final RestTemplate restTemplate,
						 @Value("${zendesk.insere.usuarios}") final String saveUri,
						 @Value("${service.token.zendesk}") final String token) {
		super();
		this.restTemplate = restTemplate;
		this.saveUri = saveUri;
		this.httpHeader = this.getHttpHeader(token);
	}

	private HttpHeaders getHttpHeader(final String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", "application/json");
		headers.setBasicAuth(token);
		return headers;
	}

	public void saveUsers(final SaveUsersRequest users) {
		try {
			HttpEntity<SaveUsersRequest> usersList = new HttpEntity<>(users, this.httpHeader);
			Object o = restTemplate.postForEntity(this.saveUri, usersList, Object.class);
			log.info(o.toString());
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}
	}
}
