package com.md.tournament.dto.converter;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    public UserDTO convert(User from) {
        return new UserDTO(
                from.getId(),
                from.getUsername(),
                from.getAge(),
                from.getRole()
        );
    }

    public List<UserDTO> convertToUserDtoList(List<User> authorList) {
        return authorList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
