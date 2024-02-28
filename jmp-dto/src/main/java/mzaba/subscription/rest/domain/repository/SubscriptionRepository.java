package mzaba.subscription.rest.domain.repository;

import mzaba.subscription.rest.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
