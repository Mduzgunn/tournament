package com.md.tournament.repository;

import com.md.tournament.enums.TournamentType;
import com.md.tournament.model.Season;
import com.md.tournament.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    boolean existsByTypeAndSeason(TournamentType type, Season season);
}
