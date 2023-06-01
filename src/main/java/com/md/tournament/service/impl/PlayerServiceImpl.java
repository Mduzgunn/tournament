package com.md.tournament.service.impl;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;
import com.md.tournament.exception.NotFoundException;
import com.md.tournament.mapper.PlayerMapper;
import com.md.tournament.model.Player;
import com.md.tournament.repository.PlayerRepository;
import com.md.tournament.repository.TeamRepository;
import com.md.tournament.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    private PlayerMapper playerMapper;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> playerList = playerRepository.findAll();
        return playerMapper.playerToPlayerDTOList(playerList);
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Player not found with id: " + id));
        return playerMapper.PlayerToPlayerDTO(player);
    }

    @Override
    public PlayerDTO createPlayer(PlayerCreateRequest createRequest) {
        Player player = playerMapper.createPlayerRequestToPlayer(createRequest);
        Player savedPlayer = playerRepository.save(player);
        return playerMapper.PlayerToPlayerDTO(savedPlayer);
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerUpdateRequest updateRequest) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Player not found with id: " + id));

        playerMapper.updatePlayerRequestToPlayer(updateRequest);
        Player updatedPlayer = playerRepository.save(existingPlayer);

        return playerMapper.PlayerToPlayerDTO(updatedPlayer);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

}
