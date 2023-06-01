package com.md.tournament.dto.requests;

import lombok.Data;

import java.util.List;


@Data
public class TournamentCreateRequest {
    private String type;
    private Long seasonId;
}
