package com.md.tournament.service.impl;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.exception.NotFoundException;
import com.md.tournament.mapper.TeamMapper;
import com.md.tournament.model.Team;
import com.md.tournament.repository.TeamRepository;
import com.md.tournament.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private TeamMapper teamMapper;

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> teamList = teamRepository.findAll();
        return teamMapper.teamToTeamDTOList(teamList);
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Team not found with id: " + id));
        return teamMapper.teamToTeamDTO(team);
    }

    @Override
    public TeamDTO createTeam(TeamCreateRequest createRequest) {
        Team team = teamMapper.createTeamRequestToTeam(createRequest);
        Team savedTeam = teamRepository.save(team);

        return teamMapper.teamToTeamDTO(savedTeam);
    }

    @Override
    public TeamDTO updateTeam(Long id, TeamUpdateRequest updateRequest) {
        Team existingTeam = teamMapper.updateTeamRequestToTeam(updateRequest);
        Team updatedTeam = teamRepository.save(existingTeam);

        return teamMapper.teamToTeamDTO(updatedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
