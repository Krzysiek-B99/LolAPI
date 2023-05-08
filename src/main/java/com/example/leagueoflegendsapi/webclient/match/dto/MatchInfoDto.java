package com.example.leagueoflegendsapi.webclient.match.dto;

import lombok.Getter;

@Getter
public class MatchInfoDto {
    private long gameCreation;
    private long gameDuration;
    private String gameMode;
}
