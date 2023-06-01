package com.md.tournament.service.impl;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;
import com.md.tournament.exception.NotFoundException;
import com.md.tournament.mapper.TournamentMapper;
import com.md.tournament.model.Tournament;
import com.md.tournament.repository.TournamentRepository;
import com.md.tournament.service.TournamentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TournamentServiceImpl implements TournamentService {
    private TournamentRepository tournamentRepository;
    private TournamentMapper tournamentMapper;

    @Override
    public List<TournamentDTO> getAllTournaments() {
        List<Tournament> tournamentList = tournamentRepository.findAll();
        return tournamentMapper.tournamentToTournamentDTOList(tournamentList);
    }

    @Override
    public TournamentDTO getTournamentById(Long id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tournament not found with id: " + id));
        return tournamentMapper.tournamentToTournamentDTO(tournament);
    }

    @Override
    public TournamentDTO createTournament(TournamentCreateRequest createRequest) {
        Tournament tournament = tournamentMapper.createTournamentRequestToTournament(createRequest);
        Tournament savedTournament = tournamentRepository.save(tournament);

        return tournamentMapper.tournamentToTournamentDTO(savedTournament);
    }

    @Override
    public TournamentDTO updateTournament(Long id, TournamentUpdateRequest updateRequest) {
        Tournament existingTournament = tournamentMapper.updateTournamentRequestToTournament(updateRequest);
        Tournament updatedTournament = tournamentRepository.save(existingTournament);

        return tournamentMapper.tournamentToTournamentDTO(updatedTournament);
    }

    @Override
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
