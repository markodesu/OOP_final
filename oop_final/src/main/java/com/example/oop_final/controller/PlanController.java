package com.example.oop_final.controller;

import com.example.oop_final.model.SubscriptionPlan;
import com.example.oop_final.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private SubscriptionPlanService planService;

    // Get all subscription plans
    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return planService.getAllSubscriptionPlans();
    }

    // Get a specific subscription plan by ID
    @GetMapping("/{id}")
    public SubscriptionPlan getPlanById(@PathVariable Long id) {
        return planService.getSubscriptionPlanById(id);
    }

    // Create a new subscription plan (Admin only)
    @PostMapping
    public SubscriptionPlan createPlan(@RequestBody SubscriptionPlan plan) {
        return planService.createPlan(plan);
    }

    // Update an existing subscription plan (Admin only)
    @PutMapping("/{id}")
    public SubscriptionPlan updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan updatedPlan) {
        return planService.updatePlan(id, updatedPlan);
    }

    // Delete a subscription plan (Admin only)
    @DeleteMapping("/{id}")
    public String deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return "Plan deleted successfully";
    }
}
