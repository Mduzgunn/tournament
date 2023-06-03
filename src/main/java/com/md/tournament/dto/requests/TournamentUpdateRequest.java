package com.md.tournament.dto.requests;

import com.md.tournament.enums.TournamentType;
import lombok.Data;

@Data
public class TournamentUpdateRequest {
    private Long id;
    private TournamentType type;
    private Long seasonId;
}
