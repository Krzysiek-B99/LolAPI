package com.example.leagueoflegendsapi.webclient.match.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchInfoDto {
    private long gameCreation;
    private long gameDuration;
    private String gameMode;
    private List<MatchParticipantDto> participants;
    private List<TeamDto> teams;
}
