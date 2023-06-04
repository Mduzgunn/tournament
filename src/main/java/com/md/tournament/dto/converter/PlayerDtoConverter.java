package com.md.tournament.dto.converter;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.UserDTO;
import com.md.tournament.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerDtoConverter {
    public PlayerDTO convert(Player from) {
        return new PlayerDTO(
                from.getId(),
                new UserDTO(
                        from.getUser().getId(),
                        from.getUser().getUsername(),
                        from.getUser().getAge(),
                        from.getUser().getRole()
                        ),
                new TeamDTO(
                        from.getTeam().getId(),
                        from.getTeam().getName()
                ),
                from.getNumber()
        );
    }

    public List<PlayerDTO> convertToPlayerDtoList(List<Player> playerList) {
        return playerList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
