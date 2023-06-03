package com.md.tournament.dto.converter;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.TeamDTO;
import com.md.tournament.model.Match;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchDtoConverter {
    public MatchDTO convert(Match from) {
        return new MatchDTO(
                from.getId(),
                new TeamDTO(
                        from.getHomeTeam().getId(),
                        from.getHomeTeam().getName()
                ),
                new TeamDTO(
                        from.getAwayTeam().getId(),
                        from.getAwayTeam().getName()
                ),
                from.getHomeTeamScore(),
                from.getAwayTeamScore()
        );
    }

    public List<MatchDTO> convertToMatchDtoList(List<Match> matchList) {
        return matchList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
