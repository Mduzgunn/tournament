package com.md.tournament.service;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.exception.TeamNotFoundException;

import java.util.List;

public interface TeamService {

    /**
     * Finds all teams
     *
     * @return A list of teams
     */
    public List<TeamDTO> getAllTeamDtoList();

    /**
     * Finds team by ID
     *
     * @param id The ID of the wanted team
     * @return The found team. If no team is found, this method returns null.
     */
    public TeamDTO getTeamById(Long id);

    /**
     * Creates a new team
     *
     * @param createTeamRequest The information of the created team
     * @return The created team
     */
    public TeamDTO createTeam(TeamCreateRequest createTeamRequest);

    /**
     * Updates the information of a team
     *
     * @return The updated team
     * @throws TeamNotFoundException If no team is found with given ID
     */
    public TeamDTO updateTeam(TeamUpdateRequest updateTeamRequest) throws TeamNotFoundException;

    /**
     * Deletes a team
     *
     * @param id The ID of the deleted team
     * @throws TeamNotFoundException If no team is found with the given ID
     */
    public String deleteTeamById(Long id) throws TeamNotFoundException;

}
