package mzaba.subscription.rest.service.controller;

import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto);
    ResponseEntity<UserResponseDto> updateUser(UserRequestDto userRequestDto);
    ResponseEntity<UserResponseDto> deleteUser(Long userId);
    ResponseEntity<UserResponseDto> getUser(Long userId);
    ResponseEntity<List<UserResponseDto>>  getAllUsers();
}
