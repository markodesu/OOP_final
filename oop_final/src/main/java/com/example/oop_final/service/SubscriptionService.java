package com.example.oop_final.service;

import com.example.oop_final.model.Subscription;
import com.example.oop_final.model.SubscriptionPlan;
import com.example.oop_final.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    // Get all subscriptions
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    // Get a subscription by ID
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found"));
    }

    // Create a new subscription
    public Subscription createSubscription(Long planId, String subscriberName, String startDate, String endDate) {
        SubscriptionPlan plan = subscriptionPlanService.getSubscriptionPlanById(planId);

        Subscription newSubscription = new Subscription();
        newSubscription.setSubscriptionPlan(plan);
        newSubscription.setSubscriberName(subscriberName);
        newSubscription.setStartDate(startDate);
        newSubscription.setEndDate(endDate);

        return subscriptionRepository.save(newSubscription);
    }

    // Update an existing subscription
    public Subscription updateSubscription(Long id, Long planId, String subscriberName, String startDate, String endDate) {
        Subscription existingSubscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found"));

        SubscriptionPlan updatedPlan = subscriptionPlanService.getSubscriptionPlanById(planId);
        existingSubscription.setSubscriptionPlan(updatedPlan);
        existingSubscription.setSubscriberName(subscriberName);
        existingSubscription.setStartDate(startDate);
        existingSubscription.setEndDate(endDate);

        return subscriptionRepository.save(existingSubscription);
    }

    // Delete a subscription
    public void deleteSubscription(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found"));
        subscriptionRepository.delete(subscription);
    }
}
