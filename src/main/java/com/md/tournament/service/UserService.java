package com.md.tournament.service;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.dto.requests.UserCreateRequest;
import com.md.tournament.dto.requests.UserUpdateRequest;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserCreateRequest createRequest);
    UserDTO updateUser(Long id, UserUpdateRequest updateRequest);
    void deleteUser(Long id);
}
