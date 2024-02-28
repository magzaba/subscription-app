package mzaba.subscription.rest.domain.converter;

import mzaba.subscription.rest.domain.dto.UserRequestDto;
import mzaba.subscription.rest.domain.model.User;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class UserRequestDtoToUserConverter implements Converter<UserRequestDto, User> {
    @Override
    public User convert(UserRequestDto userRequestDto) {
        var user = new User();
        user.setId(userRequestDto.getId());
        user.setName(userRequestDto.getName());
        user.setSurname(userRequestDto.getSurname());
        user.setBirthday(LocalDate.parse(userRequestDto.getBirthday()));
        return user;
    }
}
