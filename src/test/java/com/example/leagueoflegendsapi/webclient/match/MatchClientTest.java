package com.example.leagueoflegendsapi.webclient.match;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Team;
import com.example.leagueoflegendsapi.webclient.CustomWebClient;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchDto;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchInfoDto;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchParticipantDto;
import com.example.leagueoflegendsapi.webclient.match.dto.TeamDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class MatchClientTest {

    @Mock
    private CustomWebClient webClient;

    private MatchClient matchClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        matchClient = new MatchClient(webClient);
    }

    @Test
    public void testGetParticipantsByTeamId() {
        List<MatchParticipantDto> participants = Arrays.asList(
                new MatchParticipantDto("Player1", 100),
                new MatchParticipantDto("Player2", 100),
                new MatchParticipantDto("Player3", 200),
                new MatchParticipantDto("Player4", 200)
        );

        Map<Integer, List<MatchParticipantDto>> result = matchClient.getParticipantsByTeamId(participants);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(2, result.get(100).size());
        Assertions.assertEquals(2, result.get(200).size());
    }

    @Test
    public void testBuildTeams() {

        List<TeamDto> teamDtos = Arrays.asList(
                new TeamDto(true, 100),
                new TeamDto(false, 200)
        );

        Map<Integer, List<MatchParticipantDto>> participantsByTeam = new HashMap<>();
        participantsByTeam.put(100, Arrays.asList(
                new MatchParticipantDto("Player1", 100),
                new MatchParticipantDto("Player2", 100)
        ));
        participantsByTeam.put(200, Arrays.asList(
                new MatchParticipantDto("Player3", 200),
                new MatchParticipantDto("Player4", 200)
        ));

        List<Team> result = matchClient.buildTeams(teamDtos, participantsByTeam);

        Assertions.assertEquals(2, result.size());

        Team team1 = result.get(0);
        Assertions.assertTrue(team1.isWin());
        Assertions.assertEquals(100, team1.getTeamId());
        Assertions.assertEquals(2, team1.getParticipants().size());

        Team team2 = result.get(1);
        Assertions.assertFalse(team2.isWin());
        Assertions.assertEquals(200, team2.getTeamId());
        Assertions.assertEquals(2, team2.getParticipants().size());
    }
}