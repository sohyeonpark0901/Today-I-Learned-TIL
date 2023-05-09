package com.example.usersmicroservice.service;

import com.example.usersmicroservice.dto.UserDto;
import com.example.usersmicroservice.repository.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();
}
