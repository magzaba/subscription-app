package mzaba.subscription.rest.domain.converter;

import mzaba.subscription.rest.domain.dto.UserResponseDto;
import mzaba.subscription.rest.domain.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserToUserResponseDtoConverter implements Converter<User, UserResponseDto> {
    @Override
    public UserResponseDto convert(User user) {
        var userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setBirthday(user.getBirthday().toString());
        return userResponse;
    }
}
