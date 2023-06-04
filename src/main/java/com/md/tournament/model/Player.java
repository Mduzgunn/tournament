package com.md.tournament.model;

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
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;

    private int number;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(Long id, User user, int number, Team team) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.team = team;
    }
    public Player(User user, int number, Team team) {
        this.user = user;
        this.number = number;
        this.team = team;
    }
    public Player(Long id, int number,Team team) {
        this.id = id;
        this.number = number;
        this.team = team;
    }
    public Player() {
    }

}
