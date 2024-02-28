package mzaba.subscription.rest.domain.repository;

import mzaba.subscription.rest.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
