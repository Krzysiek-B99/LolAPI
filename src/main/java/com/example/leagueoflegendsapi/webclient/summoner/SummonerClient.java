package com.example.leagueoflegendsapi.webclient.summoner;

import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.webclient.CustomWebClient;
import com.example.leagueoflegendsapi.webclient.summoner.dto.SummonerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SummonerClient {

    private static final String SUMMONER_URL = "https://eun1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    private static final String API_KEY = System.getenv("RIOT_API_KEY");

    public Summoner getSummonerByName(String name) {
        SummonerDto summonerDto = CustomWebClient.callGetMethod(SUMMONER_URL+"{name}?api_key={apiKey}", SummonerDto.class, name, API_KEY);
        return Summoner.builder()
                .name(summonerDto.getName())
                .puuid(summonerDto.getPuuid())
                .summonerLevel(summonerDto.getSummonerLevel())
                .build();
    }


}
