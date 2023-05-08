package com.example.leagueoflegendsapi.webclient.match.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MatchInfoDto {
    private long gameCreation;
    private long gameDuration;
    private String gameMode;
    private List<MatchParticipantDto> participants;
}
