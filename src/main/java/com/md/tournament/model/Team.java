package com.md.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "managedTeam")
    @JoinColumn
    private User manager;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Team(Long id, String name, User user) {
        this.id=id;
        this.name=name;
        this.manager=user;
    }
    public Team(String name, User user, List<Player>  players) {
        this.name=name;
        this.manager=user;
        this.players=players;
    }

    public Team() {
    }
}
