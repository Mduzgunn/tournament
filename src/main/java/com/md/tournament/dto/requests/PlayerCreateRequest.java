package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class PlayerCreateRequest {
    private Long userId;
    private int number;

}
