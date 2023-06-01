package com.md.tournament.mapper;

import com.md.tournament.dto.SeasonDTO;
import com.md.tournament.dto.requests.SeasonCreateRequest;
import com.md.tournament.dto.requests.SeasonUpdateRequest;
import com.md.tournament.model.Season;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    SeasonMapper INSTANCE = Mappers.getMapper(SeasonMapper.class);

    Season createSeasonRequestToSeason(SeasonCreateRequest seasonCreateRequest);

    Season updateSeasonRequestToSeason(SeasonUpdateRequest seasonUpdateRequest);

    SeasonDTO SeasonToSeasonDTO(Season season);

    List<SeasonDTO> seasonToSeasonDTOList(List<Season> seasonList);
}

