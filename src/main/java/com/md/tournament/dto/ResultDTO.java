package com.md.tournament.dto;

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

    private SeasonDTO season;

    private TeamDTO team;
}
