package com.example.leagueoflegendsapi.webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class CustomWebClient {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String API_KEY = System.getenv("RIOT_API_KEY");

    public static <T> T callGetMethod(String url,Class<T> responseType,Object...objects) {
        return restTemplate.getForEntity(url+"?api_key="+API_KEY, responseType,objects).getBody();
    }
}
