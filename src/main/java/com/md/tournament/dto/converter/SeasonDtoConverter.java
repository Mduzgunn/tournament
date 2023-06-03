package com.md.tournament.dto.converter;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.model.Season;
import com.md.tournament.model.Tournament;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeasonDtoConverter {
    public SeasonDTO convert(Season from) {
        return new SeasonDTO(
                from.getId(),
                from.getYear(),
                getTournamentList(from.getTournaments())
        );
    }

    public List<TournamentDTO> getTournamentList(List<Tournament> players) {
        return players.stream().map(
                p -> new TournamentDTO(
                        p.getId(),
                        p.getType()
                )
        ).collect(Collectors.toList());
    }

    public List<SeasonDTO> convertToSeasonDtoList(List<Season> seasonList) {
        return seasonList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
