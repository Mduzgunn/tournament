package com.md.tournament.mapper;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.dto.requests.UserCreateRequest;
import com.md.tournament.dto.requests.UserUpdateRequest;
import com.md.tournament.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User createUserRequestToUser(UserCreateRequest userCreateRequest);

    User updateUserRequestToUser(UserUpdateRequest userUpdateRequest);

    UserDTO userToUserDTO(User user);

    List<UserDTO> userToUserDTOList(List<User> userList);
}
