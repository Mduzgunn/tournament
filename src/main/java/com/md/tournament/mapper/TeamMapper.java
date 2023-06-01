package com.md.tournament.mapper;

import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.requests.TeamCreateRequest;
import com.md.tournament.dto.requests.TeamUpdateRequest;
import com.md.tournament.model.Team;
import com.md.tournament.service.TeamService;
import com.md.tournament.service.impl.TeamServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    Team createTeamRequestToTeam(TeamCreateRequest teamCreateRequest);

    Team updateTeamRequestToTeam(TeamUpdateRequest teamUpdateRequest);

    TeamDTO teamToTeamDTO(Team team);

    List<TeamDTO> teamToTeamDTOList(List<Team> teamList);
}
