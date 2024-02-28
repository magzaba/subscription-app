package mzaba.subscription.rest.service.controller;

import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;


public interface ServiceController {

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequest);

    void deleteSubscription(Long subscriptionId);

    SubscriptionResponseDto getSubscription(Long subscriptionId);

    SubscriptionResponseDto getAllSubscriptions();
}
