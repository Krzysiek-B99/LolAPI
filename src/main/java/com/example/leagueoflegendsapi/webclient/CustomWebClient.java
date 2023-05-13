package com.example.leagueoflegendsapi.webclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CustomWebClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers;
    public CustomWebClient(HttpHeaders headers) {
        this.headers = headers;
    }
    public  <T> T callGetMethod(String url,Class<T> responseType,Object...objects) {
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, responseType, objects);
        return response.getBody();
    }
}
