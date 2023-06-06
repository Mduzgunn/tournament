package com.md.tournament.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int score = 0;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Team(Long id, String name, User user) {
        this.id=id;
        this.name=name;
        this.user=user;
    }
    public Team(String name, User user, List<Player> players) {
        this.name=name;
        this.user=user;
        this.players=players;
    }
    public Team(String name, User manager, Tournament tournament) {
        this.name=name;
        this.user=manager;
        this.tournament=tournament;
    }
    public Team() {
    }

}
