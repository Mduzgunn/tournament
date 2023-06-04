package com.md.tournament.service.impl;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.converter.TeamDtoConverter;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.exception.TeamAlreadyExistsException;
import com.md.tournament.exception.TeamNotFoundException;
import com.md.tournament.exception.UserAlreadyExistsException;
import com.md.tournament.model.Team;
import com.md.tournament.model.Tournament;
import com.md.tournament.model.User;
import com.md.tournament.service.TeamService;
import com.md.tournament.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;
    private TeamDtoConverter teamDtoConverter;
    private UserServiceImpl userService;
    private TournamentServiceImpl tournamentService;

    public TeamServiceImpl(TeamRepository teamRepository, TeamDtoConverter teamDtoConverter
            , UserServiceImpl userService, TournamentServiceImpl tournamentService) {
        this.teamRepository = teamRepository;
        this.teamDtoConverter = teamDtoConverter;
        this.userService = userService;
        this.tournamentService = tournamentService;
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
        User manager = userService.findUserById(createTeamRequest.getManagerId());
        Tournament tournament = tournamentService.findTournamentById(createTeamRequest.getTournamentId());

        if (teamRepository.existsByNameAndTournament(createTeamRequest.getName(), tournament)) {
            throw new TeamAlreadyExistsException("Takım ismi turnuva içerisinde mevcut lütfen farklı takım ismi seçiniz.");
        }
        if (teamRepository.existsByUserAndTournament(manager, tournament)) {
            throw new UserAlreadyExistsException("Belirtilen turnuva içerisinde kullanıcı başka takımda sorumlu görünüyor.");
        }

        Team team = new Team(
                createTeamRequest.getName(),
                manager,
                tournament
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

