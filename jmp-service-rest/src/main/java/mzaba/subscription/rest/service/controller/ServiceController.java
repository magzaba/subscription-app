package mzaba.subscription.rest.service.controller;

import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ServiceController {

    ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto subscriptionRequest);

    ResponseEntity<SubscriptionResponseDto>  updateSubscription(SubscriptionRequestDto subscriptionRequest);

    ResponseEntity<SubscriptionResponseDto>  deleteSubscription(Long subscriptionId);

    ResponseEntity<SubscriptionResponseDto>  getSubscription(Long subscriptionId);

    ResponseEntity<List<SubscriptionResponseDto>>  getAllSubscriptions();
}
