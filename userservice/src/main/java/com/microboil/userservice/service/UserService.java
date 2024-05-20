package com.microboil.userservice.service;

import com.microboil.userservice.dto.UserDto;
import com.microboil.userservice.model.User;
import com.microboil.userservice.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map(User::toUserDto)
                .collect(Collectors.toList());
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
