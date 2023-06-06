package com.md.tournament.repository;

import com.md.tournament.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    int countYoungPlayersByTeamId(Long teamId);

}
