package com.example.leagueoflegendsapi.webclient.history;

import com.example.leagueoflegendsapi.webclient.CustomWebClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class HistoryClient {

    private static final String HISTORY_URL = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/{id}/ids";
    private final CustomWebClient webClient;

    public HistoryClient(CustomWebClient webClient) {
        this.webClient = webClient;
    }

    public List<String> getMatchHistoryByPuuid(String id){
        String[] history = webClient.callGetMethod(HISTORY_URL,String[].class,id);
        return Arrays.stream(history).toList();
    }
}
