package com.example.leagueoflegendsapi.webclient.participant;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.MatchParticipantDetails;
import com.example.leagueoflegendsapi.webclient.CustomWebClient;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchDto;
import com.example.leagueoflegendsapi.webclient.participant.dto.ParticipantDetailsDto;
import com.example.leagueoflegendsapi.webclient.participant.dto.ParticipantDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ParticipantClient {
    private static final String MATCH_URL = "https://europe.api.riotgames.com/lol/match/v5/matches/";
    private static final String API_KEY = System.getenv("RIOT_API_KEY");

    public MatchParticipantDetails getParticipantDetailsByName(String name, String id) {
        ParticipantDto participantDto = CustomWebClient.callGetMethod(MATCH_URL+"{id}?api_key={apiKey}", ParticipantDto.class, id, API_KEY);
        ParticipantDetailsDto participantDetailsDtoByName = participantDto.getInfo().getParticipants()
                .stream().filter(participantDetailsDto -> participantDetailsDto.getSummonerName().equals(name)).findAny().orElse(null);
        return MatchParticipantDetails.builder()
                .summonerName(participantDetailsDtoByName.getSummonerName())
                .baitPings(participantDetailsDtoByName.getBaitPings())
                .spell1Cast(participantDetailsDtoByName.getSpell1Casts())
                .spell2Cast(participantDetailsDtoByName.getSpell2Casts())
                .spell3Cast(participantDetailsDtoByName.getSpell3Casts())
                .spell4Cast(participantDetailsDtoByName.getSpell4Casts())
                .build();
    }

}
