package com.example.leagueoflegendsapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Summoner {
    private String puuid;
    private String name;
    private int summonerLevel;
}
