package com.md.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private Long id;
    private TournamentDTO tournament;
    private TeamDTO homeTeam;
    private TeamDTO awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
}
