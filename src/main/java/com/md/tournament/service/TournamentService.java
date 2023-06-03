package com.md.tournament.service;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;
import com.md.tournament.exception.TournamentNotFoundException;

import java.util.List;

public interface TournamentService {

    /**
     * Finds all tournaments
     *
     * @return A list of tournaments
     */
    public List<TournamentDTO> getAllTournamentDtoList();

    /**
     * Finds tournament by ID
     *
     * @param id The ID of the wanted tournament
     * @return The found tournament. If no tournament is found, this method returns null.
     */
    public TournamentDTO getTournamentById(Long id);

    /**
     * Creates a new tournament
     *
     * @param createTournamentRequest The information of the created tournament
     * @return The created tournament
     */
    public TournamentDTO createTournament(TournamentCreateRequest createTournamentRequest);

    /**
     * Updates the information of a tournament
     *
     * @return The updated tournament
     * @throws TournamentNotFoundException If no tournament is found with the given ID
     */
    public TournamentDTO updateTournament(TournamentUpdateRequest updateTournamentRequest) throws TournamentNotFoundException;

    /**
     * Deletes a tournament
     *
     * @param id The ID of the deleted tournament
     * @throws TournamentNotFoundException If no tournament is found with the given ID
     */
    public String deleteTournamentById(Long id) throws TournamentNotFoundException;
}

