package com.md.tournament.service;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;
import com.md.tournament.exception.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {

    /**
     * Finds all players
     *
     * @return A list of players
     */
    public List<PlayerDTO> getAllPlayerDtoList();

    /**
     * Finds player by ID
     *
     * @param id The ID of the wanted player
     * @return The found player. If no player is found, this method returns null.
     */
    public PlayerDTO getPlayerById(Long id);

    /**
     * Creates a new player
     *
     * @param createPlayerRequest The information of the created player
     * @return The created player
     */
    public PlayerDTO createPlayer(PlayerCreateRequest createPlayerRequest);

    /**
     * Updates the information of a player
     *
     * @return The updated player
     */
    public PlayerDTO updatePlayer(PlayerUpdateRequest updatePlayerRequest) throws PlayerNotFoundException;

    /**
     * Deletes a player
     *
     * @param id The ID of the deleted player
     * @throws PlayerNotFoundException If no player is found with the given ID
     */
    public String deletePlayerById(Long id) throws PlayerNotFoundException;
}
