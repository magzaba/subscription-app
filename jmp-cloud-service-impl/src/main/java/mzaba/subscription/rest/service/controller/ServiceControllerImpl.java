package mzaba.subscription.rest.service.controller;

import lombok.AllArgsConstructor;
import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;
import mzaba.subscription.rest.service.SubscriptionServiceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscription-service/subscriptions")
@AllArgsConstructor
public class ServiceControllerImpl implements ServiceControllerApi {

    private SubscriptionServiceApi subscriptionService;

    @Override
    public ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto subscriptionRequest) {
        var createdSubscription = subscriptionService.createSubscription(subscriptionRequest);
        if(createdSubscription != null ){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscription);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(SubscriptionRequestDto subscriptionRequest) {
        var updatedSubscription = subscriptionService.updateSubscription(subscriptionRequest);
        if(updatedSubscription != null ){
            return ResponseEntity.ok(updatedSubscription);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteSubscription(Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SubscriptionResponseDto> getSubscription(Long subscriptionId) {
        var subscription = subscriptionService.getSubscriptionById(subscriptionId);
        if(subscription != null ){
            return ResponseEntity.ok(subscription);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions() {
        var subscriptions = subscriptionService.getAllSubscriptions();
        if(subscriptions != null){
            return ResponseEntity.ok(subscriptions);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
