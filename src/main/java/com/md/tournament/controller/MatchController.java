package com.md.tournament.controller;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;
import com.md.tournament.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/matches")
@CrossOrigin(origins = "*")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<MatchDTO> createMatch(@RequestBody MatchCreateRequest request) {
        MatchDTO createdMatch = matchService.createMatch(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
    }

    @GetMapping
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        List<MatchDTO> matchDtoList = matchService.getAllMatchDtoList();
        return ResponseEntity.ok(matchDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Long id) {
        MatchDTO matchDto = matchService.getMatchById(id);
        return ResponseEntity.ok(matchDto);
    }

    @PutMapping
    public ResponseEntity<MatchDTO> updateMatch(@RequestBody MatchUpdateRequest request) {
        MatchDTO updatedMatch = matchService.updateMatch(request);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatchById(id);
        return ResponseEntity.noContent().build();
    }
}
