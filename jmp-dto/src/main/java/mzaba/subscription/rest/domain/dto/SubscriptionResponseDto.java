package mzaba.subscription.rest.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionResponseDto {
    Long id;
    Long userId;
    String startDate;
}
