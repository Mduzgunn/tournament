package com.md.tournament.service.impl;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;
import com.md.tournament.exception.NotFoundException;
import com.md.tournament.mapper.MatchMapper;
import com.md.tournament.model.Match;
import com.md.tournament.repository.MatchRepository;
import com.md.tournament.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;
    private MatchMapper matchMapper;

    @Override
    public List<MatchDTO> getAllMatches() {
        List<Match> matchList = matchRepository.findAll();
        return matchMapper.matchToMatchDTOList(matchList);
    }

    @Override
    public MatchDTO getMatchById(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Match not found with id: " + id));
        return matchMapper.MatchToMatchDTO(match);
    }

    @Override
    public MatchDTO createMatch(MatchCreateRequest createRequest) {
        Match match = matchMapper.createMatchRequestToMatch(createRequest);
        Match savedMatch = matchRepository.save(match);
        return matchMapper.MatchToMatchDTO(savedMatch);
    }

    @Override
    public MatchDTO updateMatch(Long id, MatchUpdateRequest updateRequest) {
        Match existingMatch = matchMapper.updateMatchRequestToMatch(updateRequest);
        Match updatedMatch = matchRepository.save(existingMatch);

        return matchMapper.MatchToMatchDTO(updatedMatch);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
