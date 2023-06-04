package com.md.tournament.service.impl;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.converter.SeasonDtoConverter;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;
import com.md.tournament.exception.SeasonAlreadyExistException;
import com.md.tournament.exception.SeasonNotFoundException;
import com.md.tournament.model.Season;
import com.md.tournament.repository.SeasonRepository;
import com.md.tournament.service.SeasonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;
    private final SeasonDtoConverter seasonDtoConverter;

    public SeasonServiceImpl(SeasonRepository seasonRepository, SeasonDtoConverter seasonDtoConverter) {
        this.seasonRepository = seasonRepository;
        this.seasonDtoConverter = seasonDtoConverter;
    }

    protected Season findSeasonById(Long id) {
        return seasonRepository
                .findById(id)
                .orElseThrow(() -> new SeasonNotFoundException("Season not found " + id));
    }
    @Override
    public SeasonDTO getSeasonById(Long id) {
        return seasonDtoConverter.convert(findSeasonById(id));
    }

    protected List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }
    @Override
    public List<SeasonDTO> getAllSeasonDtoList() {
        return seasonDtoConverter.convertToSeasonDtoList(getAllSeasons());
    }
    @Override
    public String deleteSeasonById(Long id) {
        getSeasonById(id);
        seasonRepository.deleteById(id);
        return "Season deleted successfully " + id;
    }
    @Override
    public SeasonDTO createSeason(SeasonCreateRequest createSeasonRequest) {
        if (seasonRepository.existsByYear(createSeasonRequest.getYear())) {
            throw new SeasonAlreadyExistException(createSeasonRequest.getYear() + " Yılı sezonu zaten mevcut.");
        }
        Season season = new Season(
                createSeasonRequest.getYear()
        );
        return seasonDtoConverter.convert(seasonRepository.save(season));
    }
    @Override
    public SeasonDTO updateSeason(SeasonUpdateRequest updateSeasonRequest) {
        Season season = findSeasonById(updateSeasonRequest.getId());
        Season updatedSeason = new Season(
                season.getId(),
                updateSeasonRequest.getYear()
        );

        return seasonDtoConverter.convert(seasonRepository.save(updatedSeason));
    }
}
