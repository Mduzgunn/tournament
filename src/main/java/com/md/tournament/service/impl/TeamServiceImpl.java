package com.md.tournament.service.impl;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.converter.TeamDtoConverter;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.exception.TeamNotFoundException;
import com.md.tournament.model.Player;
import com.md.tournament.model.Team;
import com.md.tournament.model.User;
import com.md.tournament.service.TeamService;
import com.md.tournament.service.impl.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private TeamDtoConverter teamDtoConverter;
    private PlayerServiceImpl playerService;
    private UserServiceImpl userService;

    public TeamServiceImpl(TeamRepository teamRepository, TeamDtoConverter teamDtoConverter, PlayerServiceImpl playerService, UserServiceImpl userService) {
        this.teamRepository = teamRepository;
        this.teamDtoConverter = teamDtoConverter;
        this.playerService = playerService;
        this.userService = userService;
    }

    protected Team findTeamById(Long id) {
        return teamRepository
                .findById(id)
                .orElseThrow(() -> new TeamNotFoundException("team not found " + id));
    }
    @Override
    public TeamDTO getTeamById(Long id) {
        return teamDtoConverter.convert(findTeamById(id));
    }

    protected List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    @Override
    public List<TeamDTO> getAllTeamDtoList() {
        return teamDtoConverter.convertToTeamDtoList(getAllTeams());
    }
    @Override
    public String deleteTeamById(Long id) {
        getTeamById(id);
        teamRepository.deleteById(id);
        return "Team deleted successfully " + id;
    }
    @Override
    public TeamDTO createTeam(TeamCreateRequest createTeamRequest) {
        Player player = playerService.findPlayerById(createTeamRequest.getManagerId());
        User user = userService.findUserById(createTeamRequest.getManagerId());
        Team team = new Team(
                createTeamRequest.getName(),
                user,
                Collections.singletonList(player)
        );
        return teamDtoConverter.convert(teamRepository.save(team));
    }
    @Override
    public TeamDTO updateTeam(TeamUpdateRequest updateTeamRequest) {
        Team team = findTeamById(updateTeamRequest.getId());
        User user = userService.findUserById(updateTeamRequest.getManagerId());
        Team updateTeam = new Team(
                team.getId(),
                updateTeamRequest.getName(),
                user
        );

        return teamDtoConverter.convert(teamRepository.save(updateTeam));
    }
}

