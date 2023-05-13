package com.example.leagueoflegendsapi.webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CustomWebClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = System.getenv("RIOT_API_KEY");

    public  <T> T callGetMethod(String url,Class<T> responseType,Object...objects) {
        return restTemplate.getForEntity(url+"?api_key="+API_KEY, responseType,objects).getBody();
    }
}
