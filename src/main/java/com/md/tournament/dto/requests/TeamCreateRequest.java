package com.md.tournament.dto.requests;

import lombok.Data;

import java.util.List;

@Data
public class TeamCreateRequest {
    private String name;
    private Long managerId;
    private Long playerId;

}
