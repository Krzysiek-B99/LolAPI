package com.example.leagueoflegendsapi.service;

import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.webclient.summoner.SummonerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class SummonerService {
    private final SummonerClient summonerClient;
    public Summoner getSummoner() {
        return summonerClient.getSummonerByName("MrRisto");
    }


}
