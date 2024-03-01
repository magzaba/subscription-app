package mzaba.subscription.rest.service.controller;

import lombok.AllArgsConstructor;
import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;
import mzaba.subscription.rest.service.UserServiceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscription-service/users")
@AllArgsConstructor
public class UserControllerImpl implements UserControllerApi {
    private UserServiceApi userService;


    @Override
    public ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto) {
        var createdUser = userService.createUser(userRequestDto);
        if(createdUser != null ){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<UserResponseDto> updateUser(UserRequestDto userRequestDto) {
        var updatedUser = userService.updateUser(userRequestDto);
        if(updatedUser != null ){
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResponseDto> getUser(Long  userId) {
        var user = userService.getUserById(userId);
        if(user != null ){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        var users = userService.getAllUsers();
        if(users != null){
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
