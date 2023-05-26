package com.example.leagueoflegendsapi.webclient.match;

import com.example.leagueoflegendsapi.model.Match;
import com.example.leagueoflegendsapi.model.ParticipantDetails;
import com.example.leagueoflegendsapi.model.Team;
import com.example.leagueoflegendsapi.util.SummonerSpellidToName;
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
    public Match getMatchById(String id,boolean includeExtraDetailsFields) {
        MatchDto matchDto = webClient.callGetMethod(MATCH_URL + "{id}", MatchDto.class, id);

        Map<Integer, List<ParticipantDetails>> participantsByTeam = getParticipantsByTeamId(matchDto.getInfo().getParticipants(),includeExtraDetailsFields);

        List<Team> teams = buildTeams(matchDto.getInfo().getTeams(), participantsByTeam);

        return buildMatch(matchDto, teams);
    }

    public Map<Integer, List<ParticipantDetails>> getParticipantsByTeamId(List<MatchParticipantDto> participants, boolean includeExtraDetailsFields) {
        return participants.stream()
                .map(participant -> buildParticipantDetails(participant, includeExtraDetailsFields))
                .collect(Collectors.groupingBy(ParticipantDetails::getTeamId));
    }

    private ParticipantDetails buildParticipantDetails(MatchParticipantDto participant, boolean includeExtraDetailsFields) {
        ParticipantDetails.ParticipantDetailsBuilder builder = ParticipantDetails.builder()
                .summonerName(participant.getSummonerName())
                .championName(participant.getChampionName())
                .teamId(participant.getTeamId());

        if (includeExtraDetailsFields) {
            builder.baitPings(participant.getBaitPings())
                    .totalTimeBeingDead(participant.getTotalTimeSpentDead())
                    .longestTimeSpentLiving(participant.getLongestTimeSpentLiving())
                    .spell1Casts(participant.getSpell1Casts())
                    .spell2Casts(participant.getSpell2Casts())
                    .spell3Casts(participant.getSpell3Casts())
                    .spell4Casts(participant.getSpell4Casts())
                    .summonerSpell1Name(SummonerSpellidToName.changeSpellIdToName(participant.getSummoner1Id()))
                    .summonerSpell1Casts(participant.getSummoner1Casts())
                    .summonerSpell2Name(SummonerSpellidToName.changeSpellIdToName(participant.getSummoner2Id()))
                    .summonerSpell2Casts(participant.getSummoner2Casts())
                    ;
        }

        return builder.build();
    }
    public List<Team> buildTeams(List<TeamDto> teamDtos, Map<Integer, List<ParticipantDetails>> participantsByTeam) {
        return teamDtos.stream()
                .map(teamDto -> Team.builder()
                        .win(teamDto.isWin())
                        .teamId(teamDto.getTeamId())
                        .participants(participantsByTeam.get(teamDto.getTeamId()))
                        .build()
                )
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
