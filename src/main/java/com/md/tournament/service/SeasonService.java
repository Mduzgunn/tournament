package com.md.tournament.service;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;
import com.md.tournament.exception.SeasonNotFoundException;

import java.util.List;

public interface SeasonService {

    /**
     * Finds all seasons
     *
     * @return A list of seasons
     */
    public List<SeasonDTO> getAllSeasonDtoList();

    /**
     * Finds season by ID
     *
     * @param id The ID of the wanted season
     * @return The found season. If no season is found, this method returns null.
     */
    public SeasonDTO getSeasonById(Long id);

    /**
     * Creates a new season
     *
     * @param request The information of the created season
     * @return The created season
     */
    public SeasonDTO createSeason(SeasonCreateRequest request);

    /**
     * Updates the information of a season
     *
     * @param updateSeasonRequest The information of the updated season
     * @return The updated season
     * @throws SeasonNotFoundException If no season is found with given ID
     */
    public SeasonDTO updateSeason(SeasonUpdateRequest updateSeasonRequest) throws SeasonNotFoundException;

    /**
     * Deletes a season
     *
     * @param id The ID of the deleted season
     * @throws SeasonNotFoundException If no season is found with the given ID
     */
    public String deleteSeasonById(Long id) throws SeasonNotFoundException;

}
