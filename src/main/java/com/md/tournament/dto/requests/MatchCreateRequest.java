package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class MatchCreateRequest {
    private Long homeTeamId;
    private Long awayTeamId;
    private Long tournamentId;
}
