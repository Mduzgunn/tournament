package com.md.tournament.service;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;
import com.md.tournament.exception.SeasonNotFoundException;

import java.util.List;

public interface SeasonService {
    public List<SeasonDTO> getAllSeasonDtoList();
    public SeasonDTO getSeasonById(Long id);
    public SeasonDTO createSeason(SeasonCreateRequest request);
    public SeasonDTO updateSeason(SeasonUpdateRequest updateSeasonRequest) throws SeasonNotFoundException;
    public String deleteSeasonById(Long id) throws SeasonNotFoundException;

}
