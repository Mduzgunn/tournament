package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class TournamentUpdateRequest {
    private Long id;
    private String type;
    private Long seasonId;
}
