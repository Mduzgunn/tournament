package com.md.tournament.mapper;

import com.md.tournament.dto.MatchDTO;
import com.md.tournament.dto.requests.MatchCreateRequest;
import com.md.tournament.dto.requests.MatchUpdateRequest;
import com.md.tournament.model.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    Match createMatchRequestToMatch(MatchCreateRequest matchCreateRequest);

    Match updateMatchRequestToMatch(MatchUpdateRequest matchUpdateRequest);

    MatchDTO MatchToMatchDTO(Match match);

    List<MatchDTO> matchToMatchDTOList(List<Match> matchList);
}

