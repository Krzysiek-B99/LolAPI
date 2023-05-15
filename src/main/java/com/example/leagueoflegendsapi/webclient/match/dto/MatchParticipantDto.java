package com.example.leagueoflegendsapi.webclient.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MatchParticipantDto {
    private String championName;
    private String summonerName;
    private int teamId;

}
