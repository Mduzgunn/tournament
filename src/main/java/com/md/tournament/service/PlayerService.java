package com.md.tournament.service;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;
import com.md.tournament.exception.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {

    public List<PlayerDTO> getAllPlayerDtoList();
    public PlayerDTO getPlayerById(Long id);
    public PlayerDTO createPlayer(PlayerCreateRequest createPlayerRequest);
    public PlayerDTO updatePlayer(PlayerUpdateRequest updatePlayerRequest) throws PlayerNotFoundException;
    public String deletePlayerById(Long id) throws PlayerNotFoundException;
}
