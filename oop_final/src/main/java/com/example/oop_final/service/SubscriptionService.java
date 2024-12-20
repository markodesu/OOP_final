package com.example.oop_final.service;

import com.example.oop_final.model.Subscription;
import com.example.oop_final.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }
}
