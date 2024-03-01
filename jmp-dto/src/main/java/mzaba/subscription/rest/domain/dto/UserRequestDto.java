package mzaba.subscription.rest.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    Long id;
    String name;
    String surname;
    String birthday;
}
