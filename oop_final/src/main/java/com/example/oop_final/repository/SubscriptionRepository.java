package com.example.oop_final.repository;
import java.util.List;
import com.example.oop_final.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    // Custom query method to find active subscriptions by user ID
    List<Subscription> findByUserIdAndIsActiveTrue(Long userId);

    // Optional: Other custom queries if needed
}
