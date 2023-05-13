package com.example.leagueoflegendsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class ApiKeyConfiguration {
    @Bean
    public HttpHeaders customHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", System.getenv("RIOT_API_KEY"));
        return headers;
    }
}
