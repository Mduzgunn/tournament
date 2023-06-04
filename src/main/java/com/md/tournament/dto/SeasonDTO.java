package com.md.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {
    private Long id;
    private int year;
    private List<TournamentDTO> tournaments = new ArrayList<>();

    public SeasonDTO(Long id, int year) {
        this.id = id;
        this.year = year;
    }
}
