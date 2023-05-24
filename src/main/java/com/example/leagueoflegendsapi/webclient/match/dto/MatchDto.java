package com.example.leagueoflegendsapi.webclient.match.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDto {
    private MatchMetadataDto metadata;
    private MatchInfoDto info;

}
