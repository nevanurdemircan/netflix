package com.example.netflix.converter;

import com.example.netflix.dto.UserDto;
import com.example.netflix.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User convertToUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPremium(userDto.isPremium());
        user.setPassword(userDto.getPassword());
        user.setMembershipType(userDto.getMembershipType());

        return user;
    }

    public UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUserName(user.getUserName());
        userDto.setPremium(user.isPremium());
        userDto.setMembershipType(user.getMembershipType());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
