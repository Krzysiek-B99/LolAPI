package com.example.leagueoflegendsapi.controller;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Summoner;
import com.example.leagueoflegendsapi.service.MatchService;
import com.example.leagueoflegendsapi.service.SummonerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/match/{id}")
    public Match getMatch(@PathVariable String id){
        return matchService.getMatchDetails(id);
    }

}
