package com.md.tournament.service.impl;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.converter.MatchDtoConverter;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;
import com.md.tournament.exception.MatchNotFoundException;
import com.md.tournament.model.Match;
import com.md.tournament.model.Team;
import com.md.tournament.service.impl.repository.MatchRepository;
import com.md.tournament.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final MatchDtoConverter matchDtoConverter;
    private final TeamServiceImpl teamService;

    public MatchServiceImpl(MatchRepository matchRepository, MatchDtoConverter matchDtoConverter, TeamServiceImpl teamService) {
        this.matchRepository = matchRepository;
        this.matchDtoConverter = matchDtoConverter;
        this.teamService = teamService;
    }

    protected Match findMatchById(Long id) {
        return matchRepository
                .findById(id)
                .orElseThrow(() -> new MatchNotFoundException("match not found " + id));
    }
    @Override
    public MatchDTO getMatchById(Long id) {
        return matchDtoConverter.convert(findMatchById(id));
    }


    protected List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<MatchDTO> getAllMatchDtoList() {
        return matchDtoConverter.convertToMatchDtoList(getAllMatches());
    }

    @Override
    public String deleteMatchById(Long id) {
        getMatchById(id);
        matchRepository.deleteById(id);
        return "Match deleted successfully " + id;
    }
    @Override
    public MatchDTO createMatch(MatchCreateRequest createMatchRequest) {
        Team homeTeam = teamService.findTeamById(createMatchRequest.getHomeTeamId());
        Team awayTeam = teamService.findTeamById(createMatchRequest.getAwayTeamId());
        Match match = new Match(
                homeTeam,
                awayTeam,
                createMatchRequest.getHomeTeamScore(),
                createMatchRequest.getAwayTeamScore()
        );
        return matchDtoConverter.convert(matchRepository.save(match));
    }

    @Override
    public MatchDTO updateMatch(MatchUpdateRequest updateMatchRequest) {
        Match match = findMatchById(updateMatchRequest.getId());
        Match updateMatch = new Match(
                match.getId(),
                updateMatchRequest.getHomeTeamScore(),
                updateMatchRequest.getAwayTeamScore()
        );

        return matchDtoConverter.convert(matchRepository.save(updateMatch));
    }


}
