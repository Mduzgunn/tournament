package com.md.tournament.service;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;

import java.util.List;

public interface TournamentService {
    List<TournamentDTO> getAllTournaments();
    TournamentDTO getTournamentById(Long id);
    TournamentDTO createTournament(TournamentCreateRequest createRequest);
    TournamentDTO updateTournament(Long id, TournamentUpdateRequest updateRequest);
    void deleteTournament(Long id);
}
