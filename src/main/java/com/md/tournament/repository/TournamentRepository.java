package com.md.tournament.repository;

import com.md.tournament.enums.TournamentType;
import com.md.tournament.model.Season;
import com.md.tournament.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    boolean existsByTypeAndSeason(TournamentType type, Season season);
}
