package com.md.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private UserDTO userId;
    private int number;

    public PlayerDTO(Long id, int number) {
        this.id = id;
        this.number = number;
    }
}
