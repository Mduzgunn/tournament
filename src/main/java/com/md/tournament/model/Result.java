package com.md.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer played;

    private Integer win;

    private Integer draft;

    private Integer loss;

    @ManyToOne
    @JoinColumn(name = "id_season")
    private Season season;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

    public Result() {
    }

    public Result(Integer played, Integer win, Integer draft, Integer loss, Season season, Team team) {
        this.played = played;
        this.win = win;
        this.draft = draft;
        this.loss = loss;
        this.season = season;
        this.team = team;
    }
}
