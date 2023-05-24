package com.example.leagueoflegendsapi.webclient.match;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.Team;
import com.example.leagueoflegendsapi.webclient.CustomWebClient;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchDto;
import com.example.leagueoflegendsapi.webclient.match.dto.MatchParticipantDto;
import com.example.leagueoflegendsapi.webclient.match.dto.TeamDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MatchClient {
    private static final String MATCH_URL = "https://europe.api.riotgames.com/lol/match/v5/matches/";
    private final CustomWebClient webClient;

    public MatchClient(CustomWebClient webClient) {
        this.webClient = webClient;
    }
    public Match getMatchById(String id) {
        MatchDto matchDto = webClient.callGetMethod(MATCH_URL + "{id}", MatchDto.class, id);

        Map<Integer, List<MatchParticipantDto>> participantsByTeam = getParticipantsByTeamId(matchDto.getInfo().getParticipants());

        List<Team> teams = buildTeams(matchDto.getInfo().getTeams(), participantsByTeam);

        return buildMatch(matchDto, teams);
    }

    public Map<Integer, List<MatchParticipantDto>> getParticipantsByTeamId(List<MatchParticipantDto> participants) {
        return participants.stream()
                .collect(Collectors.groupingBy(MatchParticipantDto::getTeamId));
    }

     public List<Team> buildTeams(List<TeamDto> teamDtos, Map<Integer, List<MatchParticipantDto>> participantsByTeam) {
        return teamDtos.stream()
                .map(teamDto -> new Team(teamDto.isWin(), teamDto.getTeamId(), participantsByTeam.get(teamDto.getTeamId())))
                .toList();
    }

    private Match buildMatch(MatchDto matchDto, List<Team> teams) {
        return Match.builder()
                .matchId(matchDto.getMetadata().getMatchId())
                .gameCreation(matchDto.getInfo().getGameCreation())
                .gameDuration(matchDto.getInfo().getGameDuration())
                .gameMode(matchDto.getInfo().getGameMode())
                .teams(teams)
                .build();
    }
}
