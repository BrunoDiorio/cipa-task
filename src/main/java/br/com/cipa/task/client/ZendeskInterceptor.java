package br.com.cipa.task.client;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ZendeskInterceptor implements ClientHttpRequestInterceptor{

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		HttpRequest warpper = new HttpRequestWrapper(request);
		log.info("Request: {}, Body: {}", request, new String(body, "UTF-8"));
		ClientHttpResponse response = execution.execute(warpper, body);
		log.info("Response: {}", response);
		return response;
	}	
}
