package com.md.tournament.controller;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teams")
@CrossOrigin(origins = "*")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@Valid @RequestBody TeamCreateRequest createTeamRequest) {
        return ResponseEntity.ok(teamService.createTeam(createTeamRequest));
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getTeams() {
        List<TeamDTO> teamDtoList = teamService.getAllTeamDtoList();
        return ResponseEntity.ok(teamDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        TeamDTO teamDto = teamService.getTeamById(id);
        return ResponseEntity.ok(teamDto);
    }

    @PutMapping
    public ResponseEntity<TeamDTO> updateTeam(@Valid @RequestBody TeamUpdateRequest updateTeamRequest) {
        return ResponseEntity.ok(teamService.updateTeam(updateTeamRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeamById(id);
        return ResponseEntity.noContent().build();
    }
}
