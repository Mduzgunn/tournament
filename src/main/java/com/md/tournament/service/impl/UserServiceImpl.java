package com.md.tournament.service.impl;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.dto.converter.UserDtoConverter;
import com.md.tournament.dto.requests.UserCreateRequest;
import com.md.tournament.dto.requests.UserUpdateRequest;
import com.md.tournament.exception.UserNotFoundException;
import com.md.tournament.model.User;
import com.md.tournament.service.impl.repository.UserRepository;
import com.md.tournament.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserDtoConverter userDtoConverter;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    protected User findUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found " + id));
    }
    @Override
    public UserDTO getUserById(Long id) {
        return userDtoConverter.convert(findUserById(id));
    }

    protected List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public List<UserDTO> getAllUserDtoList() {
        return userDtoConverter.convertToUserDtoList(getAllUsers());
    }
    @Override
    public String deleteUserById(Long id) {
        getUserById(id);
        userRepository.deleteById(id);
        return "User deleted successfully " + id;
    }
    @Override
    public UserDTO createUser(UserCreateRequest createUserRequest) {
        User user = new User(
                createUserRequest.getUsername(),
                createUserRequest.getPassword(),
                createUserRequest.getRole(),
                createUserRequest.getAge()

        );
        return userDtoConverter.convert(userRepository.save(user));
    }
    @Override
    public UserDTO updateUser(UserUpdateRequest updateUserRequest) {
        User user = findUserById(updateUserRequest.getId());
        User updateUser = new User(
                user.getId(),
                user.getUsername(),
                updateUserRequest.getPassword(),
                updateUserRequest.getRole()
        );

        return userDtoConverter.convert(userRepository.save(updateUser));
    }
}
