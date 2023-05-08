package com.example.leagueoflegendsapi.service;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.webclient.match.MatchClient;
import com.example.leagueoflegendsapi.webclient.summoner.SummonerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchService {
    private final MatchClient matchClient;
    public Match getMatch() {
        return matchClient.getMatchById("EUN1_3367424860");
    }


}
