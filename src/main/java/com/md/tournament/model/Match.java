package com.md.tournament.model;

import com.md.tournament.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    public Match(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }
    public Match(Long id, int homeTeamScore, int awayTeamScore) {
        this.id = id;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }
    public Match() {
    }


}
