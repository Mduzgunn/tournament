package com.md.tournament.repository;

import com.md.tournament.model.Result;
import com.md.tournament.model.Season;
import com.md.tournament.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {

    public Result findBySeasonAndTeam(Season season, Team team);

}
