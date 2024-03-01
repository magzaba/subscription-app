package mzaba.subscription.rest.service;

import lombok.AllArgsConstructor;
import mzaba.subscription.rest.domain.converter.SubscriptionRequestDtoToSubscriptionConverter;
import mzaba.subscription.rest.domain.converter.SubscriptionToSubscriptionResponseDtoConverter;
import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.dto.SubscriptionResponseDto;
import mzaba.subscription.rest.domain.model.Subscription;
import mzaba.subscription.rest.domain.repository.SubscriptionRepository;
import mzaba.subscription.rest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionServiceApi {

    private SubscriptionRepository subscriptionRepository;
    private SubscriptionRequestDtoToSubscriptionConverter requestDtoToEntityConverter;
    private SubscriptionToSubscriptionResponseDtoConverter entityToResponseDtoConverter;
    private UserServiceImpl userService;

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequest) {
        var subscription = requestDtoToEntityConverter.convert(subscriptionRequest);
        subscription.setStartDate(LocalDate.now());
        var savedSubscription = subscriptionRepository.save(subscription);

        return entityToResponseDtoConverter.convert(savedSubscription);
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto updatedSubscriptionRequest) {
        var id = updatedSubscriptionRequest.getId();
        var subscription = getSubscriptionByIdFromRepo(id);
        var userId = updatedSubscriptionRequest.getUserId();
        subscription.setUser(userService.getUserByIdFromRepo(userId));
        subscription.setStartDate(LocalDate.now());
        return entityToResponseDtoConverter.convert(subscription);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        getSubscriptionByIdFromRepo(subscriptionId);
        subscriptionRepository.deleteById(subscriptionId);
    }

    @Override
    public SubscriptionResponseDto getSubscriptionById(Long subscriptionId) {
        var subscription = getSubscriptionByIdFromRepo(subscriptionId);
        return entityToResponseDtoConverter.convert(subscription);
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        var subscriptions = subscriptionRepository.findAll();
        return subscriptions
                .stream()
                .map(subscription -> entityToResponseDtoConverter.convert(subscription))
                .collect(Collectors.toList());
    }

    private Subscription getSubscriptionByIdFromRepo(Long subscriptionId){
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(()-> new ResourceNotFoundException("Subscription with given id: " + subscriptionId + " does not exist."));
    }
}
