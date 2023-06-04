package com.md.tournament.service.impl;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.converter.TournamentDtoConverter;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;
import com.md.tournament.exception.TournamentAlreadyExistException;
import com.md.tournament.exception.TournamentNotFoundException;
import com.md.tournament.model.Season;
import com.md.tournament.model.Tournament;
import com.md.tournament.repository.TournamentRepository;
import com.md.tournament.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;
    private final TournamentDtoConverter tournamentDtoConverter;
    private final SeasonServiceImpl seasonService;

    public TournamentServiceImpl(TournamentRepository tournamentRepository,
                                 TournamentDtoConverter tournamentDtoConverter, SeasonServiceImpl seasonService) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentDtoConverter = tournamentDtoConverter;
        this.seasonService = seasonService;
    }

    protected Tournament findTournamentById(Long id) {
        return tournamentRepository
                .findById(id)
                .orElseThrow(() -> new TournamentNotFoundException("Tournament not found " + id));
    }
    @Override
    public TournamentDTO getTournamentById(Long id) {
        return tournamentDtoConverter.convert(findTournamentById(id));
    }

    protected List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }
    @Override
    public List<TournamentDTO> getAllTournamentDtoList() {
        return tournamentDtoConverter.convertToTournamentDtoList(getAllTournaments());
    }
    @Override
    public String deleteTournamentById(Long id) {
        getTournamentById(id);
        tournamentRepository.deleteById(id);
        return "Tournament deleted successfully " + id;
    }
    @Override
    public TournamentDTO createTournament(TournamentCreateRequest createTournamentRequest) {
        Season season = seasonService.findSeasonById(createTournamentRequest.getSeasonId());

        if (tournamentRepository.existsByTypeAndSeason(createTournamentRequest.getType(), season)) {
            throw new TournamentAlreadyExistException("Sezon içerisinde seçilen turnuva tipinde bir turnuva hali hazırda devam etmekte.");
        }

        Tournament tournament = new Tournament(
                createTournamentRequest.getType(),
                season
        );
        return tournamentDtoConverter.convert(tournamentRepository.save(tournament));
    }
    @Override
    public TournamentDTO updateTournament(TournamentUpdateRequest updateTournamentRequest) {
        Tournament tournament = findTournamentById(updateTournamentRequest.getId());
        Season season = seasonService.findSeasonById(updateTournamentRequest.getSeasonId());
        Tournament updatedTournament = new Tournament(
                tournament.getId(),
                updateTournamentRequest.getType(),
                season
        );

        return tournamentDtoConverter.convert(tournamentRepository.save(updatedTournament));
    }
}
