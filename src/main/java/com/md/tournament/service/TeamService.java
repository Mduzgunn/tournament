package com.md.tournament.service;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.exception.TeamNotFoundException;

import java.util.List;

public interface TeamService {
    public List<TeamDTO> getAllTeamDtoList();
    public TeamDTO getTeamById(Long id);
    public TeamDTO createTeam(TeamCreateRequest createTeamRequest);
    public TeamDTO updateTeam(TeamUpdateRequest updateTeamRequest) throws TeamNotFoundException;
    public String deleteTeamById(Long id) throws TeamNotFoundException;

}
