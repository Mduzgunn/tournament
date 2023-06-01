package com.md.tournament.service;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;

import java.util.List;

public interface MatchService {
    List<MatchDTO> getAllMatches();
    MatchDTO getMatchById(Long id);
    MatchDTO createMatch(MatchCreateRequest createRequest);
    MatchDTO updateMatch(Long id, MatchUpdateRequest updateRequest);
    void deleteMatch(Long id);
}
