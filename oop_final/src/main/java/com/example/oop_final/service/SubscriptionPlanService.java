package com.example.oop_final.service;

import com.example.oop_final.model.SubscriptionPlan;
import com.example.oop_final.repository.SubscriptionPlanRepository; // Ensure correct import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository; // Variable naming follows conventions

    // Get all subscription plans
    public List<SubscriptionPlan> getAllSubscriptionPlans() {
        return subscriptionPlanRepository.findAll();
    }

    // Get a subscription plan by ID
    public SubscriptionPlan getSubscriptionPlanById(Long id) {
        return subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plan not found"));
    }

    // Create a new subscription plan
    public SubscriptionPlan createPlan(SubscriptionPlan plan) {
        return subscriptionPlanRepository.save(plan);
    }

    // Update an existing subscription plan
    public SubscriptionPlan updatePlan(Long id, SubscriptionPlan updatedPlan) {
        SubscriptionPlan existingPlan = subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plan not found"));

        existingPlan.setName(updatedPlan.getName());
        existingPlan.setPrice(updatedPlan.getPrice());
        existingPlan.setDurationMonths(updatedPlan.getDurationMonths());

        return subscriptionPlanRepository.save(existingPlan);
    }

    // Delete a subscription plan
    public void deletePlan(Long id) {
        SubscriptionPlan plan = subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plan not found"));
        subscriptionPlanRepository.delete(plan);
    }
}
