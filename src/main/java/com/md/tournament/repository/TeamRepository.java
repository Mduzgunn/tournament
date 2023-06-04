package com.md.tournament.repository;

import com.md.tournament.model.Player;
import com.md.tournament.model.Team;
import com.md.tournament.model.Tournament;
import com.md.tournament.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
    //belirli bir turnuvada verilen takım isminin kullanılıp kullanılmadığını kontrol eder.
    boolean existsByNameAndTournament(String name, Tournament tournament);

    //belirli bir turnuvada verilen kullanıcının takım sorumlusu olarak başka bir takımda olup olmadığını kontrol eder.
    boolean existsByUserAndTournament(User user, Tournament tournament);

//    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END " +
//            "FROM Team t JOIN t.players p " +
//            "WHERE t.tournament = :tournament AND p.user.age < :maxAge")
//    boolean existsByTournamentAndPlayersAgeLessThan(@Param("tournament") Tournament tournament, @Param("maxAge") int maxAge);
//
//
//    boolean existsByPlayersContainsAndTournament(Player player, Tournament tournament);

}
