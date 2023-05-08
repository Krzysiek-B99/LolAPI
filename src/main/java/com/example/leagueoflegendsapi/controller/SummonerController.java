package com.example.leagueoflegendsapi.controller;

import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.service.SummonerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {

    private final SummonerService summonerService;

    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/summ")
    public Summoner getSummoner(){
        return summonerService.getSummoner();
    }
}
