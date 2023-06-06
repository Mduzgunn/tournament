package com.md.tournament.service;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;
import com.md.tournament.exception.MatchNotFoundException;

import java.util.List;

public interface MatchService {
    public List<MatchDTO> getAllMatchDtoList();
    public MatchDTO getMatchById(Long id);
    public MatchDTO createMatch(MatchCreateRequest createMatchRequest);
    public MatchDTO updateMatch(MatchUpdateRequest updateMatchRequest) throws MatchNotFoundException;
    public String deleteMatchById(Long id) throws MatchNotFoundException;
}
