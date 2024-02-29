package mzaba.subscription.rest.service.controller;

import lombok.AllArgsConstructor;
import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;
import mzaba.subscription.rest.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscription-service/subscriptions")
@AllArgsConstructor
public class ServiceControllerImpl implements ServiceController{

    private SubscriptionService subscriptionService;

    @Override
    @PostMapping
    public ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequest) {
        var createdSubscription = subscriptionService.createSubscription(subscriptionRequest);
        if(createdSubscription != null ){
            return ResponseEntity.ok(createdSubscription);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequest) {
        var updatedSubscription = subscriptionService.updateSubscription(subscriptionRequest);
        if(updatedSubscription != null ){
            return ResponseEntity.ok(updatedSubscription);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<SubscriptionResponseDto> deleteSubscription(@PathVariable("id") Long subscriptionId) {
        var deletedSubscription = subscriptionService.deleteSubscription(subscriptionId);
        if(deletedSubscription != null ){
            return ResponseEntity.ok(deletedSubscription);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<SubscriptionResponseDto> getSubscription(@PathVariable("id") Long subscriptionId) {
        var subscription = subscriptionService.getSubscriptionById(subscriptionId);
        if(subscription != null ){
            return ResponseEntity.ok(subscription);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions() {
        var subscriptions = subscriptionService.getAllSubscriptions();
        if(subscriptions != null && !subscriptions.isEmpty()){
            return ResponseEntity.ok(subscriptions);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
