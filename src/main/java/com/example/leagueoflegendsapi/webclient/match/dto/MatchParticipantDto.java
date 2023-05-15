package com.example.leagueoflegendsapi.webclient.match.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MatchParticipantDto {
    private String championName;
    private String summonerName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int teamId;

    public MatchParticipantDto(String summonerName, int teamId) {
        this.summonerName = summonerName;
        this.teamId = teamId;
    }
}
