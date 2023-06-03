package com.md.tournament.service.impl.repository;

import com.md.tournament.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
