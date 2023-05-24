package com.example.leagueoflegendsapi.model;

import com.example.leagueoflegendsapi.webclient.match.dto.MatchParticipantDto;
import com.example.leagueoflegendsapi.webclient.match.dto.TeamDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Match {
    private String matchId;
    private long gameCreation;
    private long gameDuration;
    private String gameMode;
    private List<Team> teams;
}
