package com.example.leagueoflegendsapi.model;

import com.example.leagueoflegendsapi.webclient.match.dto.MatchParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Team {
    private boolean win;
    private int teamId;
    private List<MatchParticipantDto> participants;
}
