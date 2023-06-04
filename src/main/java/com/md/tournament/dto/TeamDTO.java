package com.md.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private Long id;
    private String name;
    private UserDTO manager;
    private List<PlayerDTO> players;

    public TeamDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
