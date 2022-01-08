package com.sanket.currency.converter.RestClient;


import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestGateWay {
	@Autowired
	RestTemplate template;
	@Value("${currency.converter.uri}")
	private String uri;

	HttpHeaders header = new HttpHeaders();

	HttpEntity<String> entity = new HttpEntity<>(header);

	public ResponseEntity<String> getResponseFromApi(String currencyName) {
		ResponseEntity<String> response = null;
		String finalUrl = MessageFormat.format(uri, currencyName);
		try {
			response= template.exchange(finalUrl, HttpMethod.GET,entity,String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
