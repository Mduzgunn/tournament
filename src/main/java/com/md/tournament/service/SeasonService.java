package com.md.tournament.service;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;

import java.util.List;

public interface SeasonService {
    List<SeasonDTO> getAllSeasons();
    SeasonDTO getSeasonById(Long id);
    SeasonDTO createSeason(SeasonCreateRequest createRequest);
    SeasonDTO updateSeason(Long id, SeasonUpdateRequest updateRequest);
    String deleteSeason(Long id);
}
