package com.md.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rankings")
public class RankingController {
//    private final RankingService rankingService;
//
//    @Autowired
//    public RankingController(RankingService rankingService) {
//        this.rankingService = rankingService;
//    }
//
//    @GetMapping("/{tournamentId}")
//    public ResponseEntity<RankingDto> getRanking(@PathVariable Long tournamentId) {
//        RankingDto rankingDto = rankingService.getRanking(tournamentId);
//        return ResponseEntity.ok(rankingDto);
//    }
//
//    @PutMapping("/matches/{matchId}/result")
//    public ResponseEntity<Void> updateMatchResult(@PathVariable Long matchId,
//                                                  @RequestBody UpdateMatchResultRequest updateMatchResultRequest) {
//        rankingService.updateMatchResult(matchId, updateMatchResultRequest);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{tournamentId}/matches")
//    public ResponseEntity<List<MatchDto>> getMatchesByTournament(@PathVariable Long tournamentId) {
//        List<MatchDto> matches = rankingService.getMatchesByTournament(tournamentId);
//        return ResponseEntity.ok(matches);
//    }

}
