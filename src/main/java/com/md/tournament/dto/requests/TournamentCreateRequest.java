package com.md.tournament.dto.requests;

import com.md.tournament.enums.TournamentType;
import lombok.Data;

import java.util.List;


@Data
public class TournamentCreateRequest {
    private TournamentType type;
    private Long seasonId;
}
