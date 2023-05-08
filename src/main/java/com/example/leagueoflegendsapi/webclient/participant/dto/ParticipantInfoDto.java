package com.example.leagueoflegendsapi.webclient.participant.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ParticipantInfoDto {
    private List<ParticipantDetailsDto> participants;
}
