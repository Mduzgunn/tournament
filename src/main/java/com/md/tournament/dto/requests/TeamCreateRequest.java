package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class TeamCreateRequest {
    private String name;
    private Long managerId;
    private Long tournamentId;

}
