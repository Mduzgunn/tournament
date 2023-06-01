package com.md.tournament.service.impl;

import com.md.tournament.dto.UserDTO;
import com.md.tournament.dto.requests.UserCreateRequest;
import com.md.tournament.dto.requests.UserUpdateRequest;
import com.md.tournament.exception.NotFoundException;
import com.md.tournament.mapper.UserMapper;
import com.md.tournament.model.User;
import com.md.tournament.repository.UserRepository;
import com.md.tournament.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.userToUserDTOList(userList);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserCreateRequest createRequest) {
        User user = userMapper.createUserRequestToUser(createRequest);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateRequest updateRequest) {
        User existingUser = userMapper.updateUserRequestToUser(updateRequest);
        User updatedUser = userRepository.save(existingUser);

        return userMapper.userToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
