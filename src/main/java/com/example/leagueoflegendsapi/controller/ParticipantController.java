package com.example.leagueoflegendsapi.controller;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.MatchParticipantDetails;
import com.example.leagueoflegendsapi.service.MatchService;
import com.example.leagueoflegendsapi.service.ParticipantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/part")
    public MatchParticipantDetails getParticipantDetails(){
        return participantService.getParticipantDetails();
    }
}
