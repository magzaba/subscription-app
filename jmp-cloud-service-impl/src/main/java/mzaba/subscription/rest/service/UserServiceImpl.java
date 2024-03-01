package mzaba.subscription.rest.service;

import lombok.AllArgsConstructor;
import mzaba.subscription.rest.domain.converter.UserRequestDtoToUserConverter;
import mzaba.subscription.rest.domain.converter.UserToUserResponseDtoConverter;
import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.dto.UserResponseDto;
import mzaba.subscription.rest.domain.model.User;
import mzaba.subscription.rest.domain.repository.UserRepository;
import mzaba.subscription.rest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceApi {

    private UserRepository userRepository;
    private UserRequestDtoToUserConverter userRequestDtoToUserConverter;
    private UserToUserResponseDtoConverter userToUserResponseDtoConverter;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        var user = userRequestDtoToUserConverter.convert(userRequestDto);
        var savedUser = userRepository.save(user);
        return userToUserResponseDtoConverter.convert(savedUser);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto updatedUserRequestDto) {
        var userId = updatedUserRequestDto.getId();
        var user = getUserByIdFromRepo(userId);
        user.setName(updatedUserRequestDto.getName());
        user.setSurname(updatedUserRequestDto.getSurname());
        user.setBirthday(LocalDate.parse(updatedUserRequestDto.getBirthday()));
        return userToUserResponseDtoConverter.convert(user);
    }

    @Override
    public void deleteUser(Long userId) {
        getUserByIdFromRepo(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        var user = getUserByIdFromRepo(userId);
        return userToUserResponseDtoConverter.convert(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        var users = userRepository.findAll();
        return users
                .stream()
                .map(user -> userToUserResponseDtoConverter.convert(user))
                .collect(Collectors.toList());
    }

    User getUserByIdFromRepo(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User with given id: " + userId + " does not exist."));
    }
}
