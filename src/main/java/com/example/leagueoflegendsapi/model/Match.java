package com.example.leagueoflegendsapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Match {
    private long gameCreation;
    private long gameDuration;
    private String gameMode;
}
