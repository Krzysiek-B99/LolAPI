package com.example.leagueoflegendsapi.model;

import com.example.leagueoflegendsapi.webclient.match.dto.MatchParticipantDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class Team {
    private boolean win;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int teamId;
    private List<ParticipantDetails> participants;
}
