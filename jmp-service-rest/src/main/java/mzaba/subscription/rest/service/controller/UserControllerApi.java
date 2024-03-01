package mzaba.subscription.rest.service.controller;

import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserControllerApi {

    @PostMapping
    ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto);

    @PutMapping
    ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId);

    @GetMapping(path = "/{id}")
    ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long userId);

    @GetMapping
    ResponseEntity<List<UserResponseDto>>  getAllUsers();
}
