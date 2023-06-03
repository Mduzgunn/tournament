package com.md.tournament.dto.converter;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.model.Match;
import com.md.tournament.model.Team;
import com.md.tournament.model.Tournament;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TournamentDtoConverter {
    public TournamentDTO convert(Tournament from) {
        return new TournamentDTO(
                from.getId(),
                from.getType(),
                new SeasonDTO(
                        from.getSeason().getId(),
                        from.getSeason().getYear()
                ),
                getMatchList(from.getMatchList()),
                getTeamList(from.getTeamList())
        );
    }

    public List<MatchDTO> getMatchList(List<Match> matches) {
        return matches.stream().map(
                p -> new MatchDTO(
                        p.getId(),
                        p.getHomeTeamScore(),
                        p.getAwayTeamScore()
                )
        ).collect(Collectors.toList());
    }

    public List<TeamDTO> getTeamList(List<Team> teamList) {
        return teamList.stream().map(
                p -> new TeamDTO(
                        p.getId(),
                        p.getName()
                )
        ).collect(Collectors.toList());
    }

    public List<TournamentDTO> convertToTournamentDtoList(List<Tournament> tournamentList) {
        return tournamentList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
