package mzaba.subscription.rest.service;

import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionServiceApi {

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequest);

    void deleteSubscription(Long subscriptionId);

    SubscriptionResponseDto getSubscriptionById(Long subscriptionId);

    List<SubscriptionResponseDto> getAllSubscriptions();

}
