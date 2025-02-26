package com.example.netflix.service;

import com.example.netflix.converter.UserConverter;
import com.example.netflix.dto.UserDto;
import com.example.netflix.entity.User;
import com.example.netflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public User save(UserDto userDto) {
        User user = userConverter.convertToUser(userDto);
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
