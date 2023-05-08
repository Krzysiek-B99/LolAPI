package com.example.leagueoflegendsapi.webclient.participant.dto;

import lombok.Getter;

@Getter
public class ParticipantDetailsDto {
    private String summonerName;
    private int baitPings;
    private int spell1Casts;
    private int spell2Casts;
    private int spell3Casts;
    private int spell4Casts;
}
