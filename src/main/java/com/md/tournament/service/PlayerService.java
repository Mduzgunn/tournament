package com.md.tournament.service;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;

import java.util.List;

public interface PlayerService {
    List<PlayerDTO> getAllPlayers();
    PlayerDTO getPlayerById(Long id);
    PlayerDTO createPlayer(PlayerCreateRequest createRequest);
    PlayerDTO updatePlayer(Long id, PlayerUpdateRequest updateRequest);
    void deletePlayer(Long id);
}
