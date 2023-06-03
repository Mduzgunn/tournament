package com.md.tournament.dto.converter;

import com.md.tournament.dto.PlayerDTO;
import com.md.tournament.dto.TeamDTO;
import com.md.tournament.dto.UserDTO;
import com.md.tournament.model.Player;
import com.md.tournament.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamDtoConverter {
    public TeamDTO convert(Team from) {
        return new TeamDTO(
                from.getId(),
                from.getName(),
                new UserDTO(from.getManager().getId(),
                        from.getManager().getUsername(),
                        from.getManager().getAge(),
                        from.getManager().getRole()
                ),
                getPlayerList(from.getPlayers())
        );
    }

    public List<PlayerDTO> getPlayerList(List<Player> players){
        return players.stream().map(
                p -> new PlayerDTO(
                        p.getId(),
                        p.getNumber()
                )
        ).collect(Collectors.toList());
    }
    public List<TeamDTO> convertToTeamDtoList(List<Team> teamList) {
        return teamList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
