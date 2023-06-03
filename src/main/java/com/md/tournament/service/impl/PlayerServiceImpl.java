package com.md.tournament.service.impl;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.converter.PlayerDtoConverter;
import com.md.tournament.dto.requests.PlayerCreateRequest;
import com.md.tournament.dto.requests.PlayerUpdateRequest;
import com.md.tournament.exception.PlayerNotFoundException;
import com.md.tournament.model.Player;
import com.md.tournament.model.User;
import com.md.tournament.service.impl.repository.PlayerRepository;
import com.md.tournament.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    private PlayerDtoConverter playerDtoConverter;
    private UserServiceImpl userService;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerDtoConverter playerDtoConverter, UserServiceImpl userService) {
        this.playerRepository = playerRepository;
        this.playerDtoConverter = playerDtoConverter;
        this.userService = userService;
    }

    protected Player findPlayerById(Long id) {
        return playerRepository
                .findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + id));
    }
    @Override
    public PlayerDTO getPlayerById(Long id) {
        return playerDtoConverter.convert(findPlayerById(id));
    }

    protected List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    @Override
    public List<PlayerDTO> getAllPlayerDtoList() {
        return playerDtoConverter.convertToPlayerDtoList(getAllPlayers());
    }
    @Override
    public String deletePlayerById(Long id) {
        Player player = findPlayerById(id);
        playerRepository.deleteById(id);
        return "Player deleted successfully with ID: " + id;
    }
    @Override
    public PlayerDTO createPlayer(PlayerCreateRequest createPlayerRequest) {
        User user = userService.findUserById(createPlayerRequest.getUserId());
        Player player = new Player(
                user,
                createPlayerRequest.getNumber()
        );
        return playerDtoConverter.convert(playerRepository.save(player));
    }
    @Override
    public PlayerDTO updatePlayer(PlayerUpdateRequest updatePlayerRequest) {
        Player player = findPlayerById(updatePlayerRequest.getId());
        Player updatedPlayer = new Player(
                player.getId(),
                updatePlayerRequest.getNumber()
        );
        return playerDtoConverter.convert(playerRepository.save(updatedPlayer));
    }
}
