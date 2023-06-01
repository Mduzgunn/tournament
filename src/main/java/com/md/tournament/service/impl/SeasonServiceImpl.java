package com.md.tournament.service.impl;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;
import com.md.tournament.exception.NotFoundException;
import com.md.tournament.mapper.SeasonMapper;
import com.md.tournament.model.Season;
import com.md.tournament.repository.SeasonRepository;
import com.md.tournament.service.SeasonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeasonServiceImpl implements SeasonService {
    private SeasonRepository seasonRepository;
    private SeasonMapper seasonMapper;

    @Override
    public List<SeasonDTO> getAllSeasons() {
        List<Season> seasonList = seasonRepository.findAll();
        return seasonMapper.seasonToSeasonDTOList(seasonList);
    }

    @Override
    public SeasonDTO getSeasonById(Long id) {
        Season season = seasonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Season not found with id: " + id));
        return seasonMapper.SeasonToSeasonDTO(season);
    }

    @Override
    public SeasonDTO createSeason(SeasonCreateRequest createRequest) {
        Season season = seasonMapper.createSeasonRequestToSeason(createRequest);
        return seasonMapper.SeasonToSeasonDTO(seasonRepository.save(season));
    }

    @Override
    public SeasonDTO updateSeason(Long id, SeasonUpdateRequest updateRequest) {
        Season existingSeason = seasonMapper.updateSeasonRequestToSeason(updateRequest);
        return seasonMapper.SeasonToSeasonDTO(seasonRepository.save(existingSeason));
    }

    @Override
    public String deleteSeason(Long id) {
        seasonRepository.deleteById(id);
        return "actor deleted successfully " + id;
    }
}
