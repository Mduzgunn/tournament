package com.md.tournament.service;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;
import com.md.tournament.exception.MatchNotFoundException;
import com.md.tournament.model.Match;

import java.util.List;

public interface MatchService {

    /**
     * Finds all matchs
     *
     * @return A list of matchs
     */
    public List<MatchDTO> getAllMatchDtoList();

    /**
     * Finds match by ID
     *
     * @param id The ID of the wanted match
     * @return The found match. If no match is found, this method returns null.
     */
    public MatchDTO getMatchById(Long id);

    /**
     * Creates a new match
     *
     * @param createMatchRequest The information of the created match
     * @return The created match
     */
    public MatchDTO createMatch(MatchCreateRequest createMatchRequest);

    /**
     * Updates the information of a match
     *
     * @param updateMatchRequest The information of the updated match
     * @return The updated match
     * @throws MatchNotFoundException If no match is found with given ID
     */
    public MatchDTO updateMatch(MatchUpdateRequest updateMatchRequest) throws MatchNotFoundException;

    /**
     * Deletes a match
     *
     * @param id The ID of the deleted match
     * @throws MatchNotFoundException If no match is found with the given ID
     */
    public String deleteMatchById(Long id) throws MatchNotFoundException;

}
