package com.md.tournament.controller;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;
import com.md.tournament.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "*")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerCreateRequest request) {
        PlayerDTO createdPlayer = playerService.createPlayer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> playerDtoList = playerService.getAllPlayerDtoList();
        return ResponseEntity.ok(playerDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        PlayerDTO playerDto = playerService.getPlayerById(id);
        return ResponseEntity.ok(playerDto);
    }

    @PutMapping
    public ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerUpdateRequest request) {
        PlayerDTO updatedPlayer = playerService.updatePlayer(request);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return ResponseEntity.noContent().build();
    }
}
