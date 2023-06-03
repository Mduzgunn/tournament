package com.md.tournament.service.impl.repository;

import com.md.tournament.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
