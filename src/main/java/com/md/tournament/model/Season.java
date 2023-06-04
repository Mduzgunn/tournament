package com.md.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;

    @OneToMany(mappedBy = "season")
    private List<Tournament> tournaments = new ArrayList<>();

    public Season(Long id, int year) {
        this.id=id;
        this.year=year;
    }
    public Season(int year) {
        this.year=year;
    }
    public Season() {
    }

}
