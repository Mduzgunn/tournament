package com.md.tournament.service;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.dto.requests.UserCreateRequest;
import com.md.tournament.dto.requests.UserUpdateRequest;
import com.md.tournament.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    /**
     * Finds all users
     *
     * @return A list of users
     */
    public List<UserDTO> getAllUserDtoList();

    /**
     * Finds user by ID
     *
     * @param id The ID of the wanted user
     * @return The found user. If no user is found, this method returns null.
     */
    public UserDTO getUserById(Long id);

    /**
     * Creates a new user
     *
     * @param createUserRequest The information of the created user
     * @return The created user
     */
    public UserDTO createUser(UserCreateRequest createUserRequest);

    /**
     * Updates the information of a user
     *
     * @param id The ID of the wanted user
     * @param updateUserRequest The information of the updated user
     * @return The updated user
     * @throws UserNotFoundException If no user is found with given ID
     */
    public UserDTO updateUser(UserUpdateRequest updateUserRequest) throws UserNotFoundException;

    /**
     * Deletes a user
     *
     * @param id The ID of the deleted user
     * @throws UserNotFoundException If no user is found with the given ID
     */
    public String deleteUserById(Long id) throws UserNotFoundException;

}
