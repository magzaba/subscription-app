package mzaba.subscription.rest.domain.converter;

import mzaba.subscription.rest.domain.dto.SubscriptionRequestDto;
import mzaba.subscription.rest.domain.model.Subscription;
import mzaba.subscription.rest.domain.repository.UserRepository;
import org.springframework.core.convert.converter.Converter;

public class SubscriptionRequestDtoToSubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {

    private UserRepository userRepository;

    public SubscriptionRequestDtoToSubscriptionConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Subscription convert(SubscriptionRequestDto subscriptionRequestDto) {
        var subscription = new Subscription();
        subscription.setId(subscriptionRequestDto.getId());
        subscription.setUser(userRepository.getReferenceById(subscriptionRequestDto.getUserId()));
        return subscription;
    }
}
