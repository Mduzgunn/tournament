package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class MatchUpdateRequest {
    private Long id;
    private int homeTeamScore;
    private int awayTeamScore;
}
