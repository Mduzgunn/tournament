package com.md.tournament.service;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.dto.requests.UserCreateRequest;
import com.md.tournament.dto.requests.UserUpdateRequest;
import com.md.tournament.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUserDtoList();
    public UserDTO getUserById(Long id);
    public UserDTO createUser(UserCreateRequest createUserRequest);
    public UserDTO updateUser(UserUpdateRequest updateUserRequest) throws UserNotFoundException;
    public String deleteUserById(Long id) throws UserNotFoundException;

}
