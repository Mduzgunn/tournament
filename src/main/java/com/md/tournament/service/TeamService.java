package com.md.tournament.service;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;

import java.util.List;

public interface TeamService {
    List<TeamDTO> getAllTeams();
    TeamDTO getTeamById(Long id);
    TeamDTO createTeam(TeamCreateRequest createRequest);
    TeamDTO updateTeam(Long id, TeamUpdateRequest updateRequest);
    void deleteTeam(Long id);
}
