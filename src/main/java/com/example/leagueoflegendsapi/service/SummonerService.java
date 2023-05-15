package com.example.leagueoflegendsapi.service;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.webclient.history.HistoryClient;
import com.example.leagueoflegendsapi.webclient.summoner.SummonerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SummonerService {
    private final SummonerClient summonerClient;
    private final HistoryClient historyClient;
    private final MatchService matchService;


    public Summoner getSummonerInfo(String name) {
        return summonerClient.getSummonerByName(name);
    }
    public List<Match> getHistoryByName(String name){
        String summonerPuuid = getSummonerInfo(name).getPuuid();
        List<String> matchesIds =  historyClient.getMatchHistoryByPuuid(summonerPuuid);
        List<Match> matchesHistory = new ArrayList<>();
        for(String matchId : matchesIds){
            matchesHistory.add(matchService.getMatchDetails(matchId));
        }
        return matchesHistory;
    }


}
