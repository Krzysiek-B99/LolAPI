package com.example.leagueoflegendsapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantDetails {
    private String championName;
    private String summonerName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int teamId;
    private Integer baitPings; //Integer because can be null (@JsonInclude) int by default is 0 not null

}
