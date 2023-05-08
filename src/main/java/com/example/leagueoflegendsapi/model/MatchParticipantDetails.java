package com.example.leagueoflegendsapi.model;

import com.example.leagueoflegendsapi.webclient.match.dto.MatchParticipantDto;
import com.example.leagueoflegendsapi.webclient.participant.dto.ParticipantDetailsDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MatchParticipantDetails {
    private String summonerName;
    private int baitPings;
    private int spell1Cast;
    private int spell2Cast;
    private int spell3Cast;
    private int spell4Cast;
}
