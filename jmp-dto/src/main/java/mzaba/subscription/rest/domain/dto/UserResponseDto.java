package mzaba.subscription.rest.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    Long id;
    String name;
    String surname;
    String birthday;
}
