package com.example.leagueoflegendsapi.controller;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.service.SummonerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummonerController {

    private final SummonerService summonerService;

    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/summoner/{name}")
    public Summoner getSummoner(@PathVariable String name){
        return summonerService.getSummonerInfo(name);
    }

    @GetMapping("/history/{name}")
    public List<Match> getSummonerHistory(@PathVariable String name){
        return summonerService.getHistoryByName(name);
    }
}
