package com.md.tournament.dto;

import com.md.tournament.model.Season;
import com.md.tournament.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private Long id;
    private Integer played;
    private Integer win;
    private Integer draft;
    private Integer loss;
    private Season season;
    private Team team;
}
