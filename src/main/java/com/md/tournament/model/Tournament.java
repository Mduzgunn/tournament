package com.md.tournament.model;

import com.md.tournament.enums.TournamentType;
import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TournamentType type;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "tournament")
    private List<Match> matchList = new ArrayList<>();

    @OneToMany(mappedBy = "tournament")
    private List<Team> teamList = new ArrayList<>();


    public Tournament(Long id, TournamentType type, Season season) {
        this.id = id;
        this.type = type;
        this.season = season;
    }
    public Tournament(TournamentType type, Season season) {
        this.type = type;
        this.season = season;
    }
    public Tournament() {}

}
