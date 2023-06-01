package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class MatchUpdateRequest {
    private Long id;
    private Long tournamentId;
    private Long homeTeamId;
    private Long awayTeamId;
    private int homeTeamScore;
    private int awayTeamScore;
}
