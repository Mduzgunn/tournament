package com.md.tournament.controller;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;
import com.md.tournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin(origins = "*")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentCreateRequest request) {
        TournamentDTO createdTournament = tournamentService.createTournament(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTournament);
    }

    @GetMapping
    public ResponseEntity<List<TournamentDTO>> getAllTournaments() {
        List<TournamentDTO> tournamentDtoList = tournamentService.getAllTournamentDtoList();
        return ResponseEntity.ok(tournamentDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentDTO> getTournamentById(@PathVariable Long id) {
        TournamentDTO tournamentDto = tournamentService.getTournamentById(id);
        return ResponseEntity.ok(tournamentDto);
    }

    @PutMapping
    public ResponseEntity<TournamentDTO> updateTournament(@RequestBody TournamentUpdateRequest request) {
        TournamentDTO updatedTournament = tournamentService.updateTournament(request);
        return ResponseEntity.ok(updatedTournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournamentById(id);
        return ResponseEntity.noContent().build();
    }
}
