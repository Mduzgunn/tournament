package com.md.tournament.dto;

import com.md.tournament.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private UserDTO userId;
    private TeamDTO teamId;
    private int number;

    public PlayerDTO(Long id, int number) {
        this.id = id;
        this.number = number;
    }

    public PlayerDTO(Long id, int number, UserDTO userId) {
        this.id = id;
        this.number = number;
        this.userId = userId;
    }

    public PlayerDTO(Long id, int number, User user) {
    }
}
