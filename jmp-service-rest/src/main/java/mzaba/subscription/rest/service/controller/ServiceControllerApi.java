package mzaba.subscription.rest.service.controller;

import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface ServiceControllerApi {

    @PostMapping
    ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequest);

    @PutMapping
    ResponseEntity<SubscriptionResponseDto>  updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequest);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<Void>  deleteSubscription(@PathVariable("id") Long subscriptionId);

    @GetMapping(path = "/{id}")
    ResponseEntity<SubscriptionResponseDto>  getSubscription(@PathVariable("id") Long subscriptionId);

    @GetMapping
    ResponseEntity<List<SubscriptionResponseDto>>  getAllSubscriptions();
}
