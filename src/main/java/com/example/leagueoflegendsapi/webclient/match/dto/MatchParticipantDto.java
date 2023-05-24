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
    private Integer baitPings;
    private Integer totalTimeSpentDead;
    private Integer longestTimeSpentLiving;
    private Integer spell1Casts;
    private Integer spell2Casts;
    private Integer spell3Casts;
    private Integer spell4Casts;
    private Integer summoner1Casts;
    private Integer summoner1Id;
    private Integer summoner2Casts;
    private Integer summoner2Id;

    public MatchParticipantDto(String summonerName, int teamId) {
        this.summonerName = summonerName;
        this.teamId = teamId;
    }
}
