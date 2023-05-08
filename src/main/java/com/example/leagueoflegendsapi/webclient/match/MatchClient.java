package com.example.leagueoflegendsapi.webclient.match;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchDto;
import com.example.leagueoflegendsapi.webclient.summoner.dto.SummonerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MatchClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String SUMMONER_URL = "https://europe.api.riotgames.com/lol/match/v5/matches/";
    private static final String API_KEY = System.getenv("RIOT_API_KEY");

    public Match getMatchById(String name) {
        MatchDto matchDto = callGetMethod("{name}?api_key={apiKey}", MatchDto.class, name, API_KEY);
        return Match.builder()
                .gameCreation(matchDto.getInfo().getGameCreation())
                .gameDuration(matchDto.getInfo().getGameDuration())
                .gameMode(matchDto.getInfo().getGameMode())
                .build();
    }

    private <T> T callGetMethod(String url,Class<T> responseType,Object...objects) {
        return restTemplate.getForEntity(SUMMONER_URL + url,
                responseType,objects).getBody();
    }
}