package com.md.tournament.dto;

import com.md.tournament.model.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentDTO {
    private Long id;
    private String type;
    private SeasonDTO season;
    private List<MatchDTO> matches;
}
