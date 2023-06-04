package com.md.tournament.dto.requests;

import com.md.tournament.dto.TeamDTO;
import lombok.Data;

@Data
public class MatchUpdateRequest {
    private Long id;
    private Long homeTeamId;
    private Long awayTeamId;
    private int homeTeamScore;
    private int awayTeamScore;
}
