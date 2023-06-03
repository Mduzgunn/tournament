package com.md.tournament.service.impl.repository;

import com.md.tournament.model.Player;
import com.md.tournament.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT COUNT(p) FROM Player p WHERE p.team = :team AND p.user.age < 30")
    int countYoungPlayersByTeam(@Param("team") Team team);

}
