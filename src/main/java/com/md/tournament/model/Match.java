package com.md.tournament.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_team_home")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "id_team_away")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    private int homeTeamScore;

    private int awayTeamScore;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    public Match(Long id, int homeTeamScore, int awayTeamScore) {
        this.id = id;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }
    public Match() {
    }

}
