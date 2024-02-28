package mzaba.subscription.rest.service.controller;

import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;

public interface UserController {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto);
    void deleteUser(Long userId);
    UserResponseDto getUser(Long userId);
    UserResponseDto getAllUsers();
}
