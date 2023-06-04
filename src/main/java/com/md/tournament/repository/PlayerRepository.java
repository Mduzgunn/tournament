package com.md.tournament.repository;

import com.md.tournament.model.Player;
import com.md.tournament.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    int countYoungPlayersByTeamId(Long teamId);

}
