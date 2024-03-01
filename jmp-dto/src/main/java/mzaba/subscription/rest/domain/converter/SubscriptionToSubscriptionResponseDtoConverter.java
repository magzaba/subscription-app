package mzaba.subscription.rest.domain.converter;

import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;
import mzaba.subscription.rest.domain.model.Subscription;
import org.springframework.core.convert.converter.Converter;

public class SubscriptionToSubscriptionResponseDtoConverter implements Converter<Subscription, SubscriptionResponseDto> {
    @Override
    public SubscriptionResponseDto convert(Subscription subscription) {
        var subscriptionResponseDto = new SubscriptionResponseDto();
        subscriptionResponseDto.setId(subscription.getId());
        subscriptionResponseDto.setUserId(subscription.getUser().getId());
        subscriptionResponseDto.setStartDate(subscription.getStartDate().toString());
        return subscriptionResponseDto;
    }
}
