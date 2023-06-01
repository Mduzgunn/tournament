package com.md.tournament.mapper;

import com.md.tournament.dto.TournamentDTO;
import com.md.tournament.dto.requests.TournamentCreateRequest;
import com.md.tournament.dto.requests.TournamentUpdateRequest;
import com.md.tournament.model.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    TournamentMapper INSTANCE = Mappers.getMapper(TournamentMapper.class);

    Tournament createTournamentRequestToTournament(TournamentCreateRequest tournamentCreateRequest);

    Tournament updateTournamentRequestToTournament(TournamentUpdateRequest tournamentUpdateRequest);

    TournamentDTO tournamentToTournamentDTO(Tournament tournament);

    List<TournamentDTO> tournamentToTournamentDTOList(List<Tournament> tournamentList);
}
