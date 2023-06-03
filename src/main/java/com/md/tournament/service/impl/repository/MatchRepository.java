package com.md.tournament.service.impl.repository;

import com.md.tournament.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
