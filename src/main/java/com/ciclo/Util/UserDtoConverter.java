package com.ciclo.Util;

import java.util.List;
import java.util.stream.Collectors;

import com.ciclo.Dto.UserResponse;
import com.ciclo.Entities.User;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    private ModelMapper modelMapper;
    public UserDtoConverter(ModelMapper modelMapper) { this.modelMapper = modelMapper; }
    public UserResponse convertUserToDto(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
    public List<UserResponse> convertUserToDto(List<User> users) {
        return users.stream()
                .map(user->convertUserToDto(user))
                .collect(Collectors.toList());
    }
}
