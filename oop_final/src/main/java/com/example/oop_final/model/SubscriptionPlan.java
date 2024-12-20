package com.example.oop_final.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Plan name
    private String description; // Plan description
    private Double price; // Price of the plan
    private Integer durationMonths; // Duration of the plan in months
}
