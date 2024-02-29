package mzaba.subscription.rest.service;

import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionService {

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequest);

    SubscriptionResponseDto deleteSubscription(Long subscriptionId);

    SubscriptionResponseDto getSubscriptionById(Long subscriptionId);

    List<SubscriptionResponseDto> getAllSubscriptions();

}
