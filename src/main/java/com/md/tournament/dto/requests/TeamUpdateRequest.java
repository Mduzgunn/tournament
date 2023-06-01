package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class TeamUpdateRequest {
    private Long id;
    private String name;
    private Long managerId;
}
