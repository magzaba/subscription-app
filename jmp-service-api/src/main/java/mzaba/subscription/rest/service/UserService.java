package mzaba.subscription.rest.service;

import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto);
    UserResponseDto deleteUser(Long userId);
    UserResponseDto getUserById(Long userId);
    List<UserResponseDto> getAllUsers();
}
