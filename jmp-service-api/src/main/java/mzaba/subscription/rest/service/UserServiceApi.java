package mzaba.subscription.rest.service;

import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;

import java.util.List;

public interface UserServiceApi {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto);
    void deleteUser(Long userId);
    UserResponseDto getUserById(Long userId);
    List<UserResponseDto> getAllUsers();
}
