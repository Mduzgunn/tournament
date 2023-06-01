package com.md.tournament.dto.requests;

import lombok.Data;

@Data
public class PlayerCreateRequest {
    private String name;
    private int number;
    private int age;
    private Long teamId;
}
