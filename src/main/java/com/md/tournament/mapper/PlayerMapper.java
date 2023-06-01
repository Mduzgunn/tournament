package com.md.tournament.mapper;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;
import com.md.tournament.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    Player createPlayerRequestToPlayer(PlayerCreateRequest playerCreateRequest);

    Player updatePlayerRequestToPlayer(PlayerUpdateRequest playerUpdateRequest);

    PlayerDTO PlayerToPlayerDTO(Player player);

    List<PlayerDTO> playerToPlayerDTOList(List<Player> playerList);
}

