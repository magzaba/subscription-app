package mzaba.subscription.rest.domain.config;

import mzaba.subscription.rest.domain.converter.SubscriptionRequestDtoToSubscriptionConverter;
import mzaba.subscription.rest.domain.converter.SubscriptionToSubscriptionResponseDtoConverter;
import mzaba.subscription.rest.domain.converter.UserRequestDtoToUserConverter;
import mzaba.subscription.rest.domain.converter.UserToUserResponseDtoConverter;
import mzaba.subscription.rest.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    @Bean
    public SubscriptionRequestDtoToSubscriptionConverter subscriptionRequestDtoToSubscriptionConverter(UserRepository userRepository){
        return new SubscriptionRequestDtoToSubscriptionConverter(userRepository);
    }

    @Bean
    public SubscriptionToSubscriptionResponseDtoConverter subscriptionToSubscriptionResponseDtoConverter(){
        return new SubscriptionToSubscriptionResponseDtoConverter();
    }

    @Bean
    public UserRequestDtoToUserConverter userRequestDtoToUserConverter(){
        return new UserRequestDtoToUserConverter();
    }

    @Bean
    public UserToUserResponseDtoConverter userToUserResponseDtoConverter(){
        return new UserToUserResponseDtoConverter();
    }



}
