package com.md.tournament.service;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;
import com.md.tournament.exception.TournamentNotFoundException;

import java.util.List;

public interface TournamentService {
    public List<TournamentDTO> getAllTournamentDtoList();
    public TournamentDTO getTournamentById(Long id);
    public TournamentDTO createTournament(TournamentCreateRequest createTournamentRequest);
    public TournamentDTO updateTournament(TournamentUpdateRequest updateTournamentRequest) throws TournamentNotFoundException;
    public String deleteTournamentById(Long id) throws TournamentNotFoundException;
}

