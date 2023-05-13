package com.example.leagueoflegendsapi.webclient.match;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.webclient.CustomWebClient;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MatchClient {
    private static final String MATCH_URL = "https://europe.api.riotgames.com/lol/match/v5/matches/";
    private final CustomWebClient webClient;

    public MatchClient(CustomWebClient webClient) {
        this.webClient = webClient;
    }
    public Match getMatchById(String id) {
        MatchDto matchDto = webClient.callGetMethod(MATCH_URL+"{id}", MatchDto.class, id);
        return Match.builder()
                .gameCreation(matchDto.getInfo().getGameCreation())
                .gameDuration(matchDto.getInfo().getGameDuration())
                .gameMode(matchDto.getInfo().getGameMode())
                .participants(matchDto.getInfo().getParticipants())
                .build();
    }
}
