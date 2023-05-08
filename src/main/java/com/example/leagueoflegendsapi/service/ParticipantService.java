package com.example.leagueoflegendsapi.service;

import com.example.leagueoflegendsapi.model.MatchParticipantDetails;
import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.webclient.participant.ParticipantClient;
import com.example.leagueoflegendsapi.webclient.summoner.SummonerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantClient participantClient;
    public MatchParticipantDetails getParticipantDetails() {
        return participantClient.getParticipantDetailsByName("MrRisto","EUN1_3367424860");
    }


}
