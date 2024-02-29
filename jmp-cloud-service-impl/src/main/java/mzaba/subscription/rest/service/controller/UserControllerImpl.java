package mzaba.subscription.rest.service.controller;

import lombok.AllArgsConstructor;
import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;
import mzaba.subscription.rest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscription-service/users")
@AllArgsConstructor
public class UserControllerImpl implements UserController{
    private UserService userService;


    @Override
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        var createdUser = userService.createUser(userRequestDto);
        if(createdUser != null ){
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto) {
        var updatedUser = userService.updateUser(userRequestDto);
        if(updatedUser != null ){
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable("id") Long userId) {
        var deletedUser = userService.deleteUser(userId);
        if(deletedUser != null ){
            return ResponseEntity.ok(deletedUser);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long  userId) {
        var user = userService.getUserById(userId);
        if(user != null ){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        var users = userService.getAllUsers();
        if(users != null && !users.isEmpty()){
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
