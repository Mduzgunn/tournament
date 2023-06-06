package com.md.tournament.dto;

import com.md.tournament.enums.TournamentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentDTO {
    private Long id;
    private TournamentType type;
    private SeasonDTO season;
    private List<MatchDTO> matchList;
    private List<TeamDTO> teamList;

    public TournamentDTO(Long id, TournamentType type) {
        this.id = id;
        this.type = type;
    }
}
