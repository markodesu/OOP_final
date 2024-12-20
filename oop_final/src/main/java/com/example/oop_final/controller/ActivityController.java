package com.example.oop_final.controller;

import com.example.oop_final.model.ActivityLog;
import com.example.oop_final.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityLogService activityLogService;

    // Endpoint for member check-in
    @PostMapping("/check-in")
    public ActivityLog checkIn(@RequestParam Long userId) {
        return activityLogService.checkIn(userId);
    }

    // Endpoint for member check-out
    @PostMapping("/check-out")
    public ActivityLog checkOut(@RequestParam Long userId) {
        return activityLogService.checkOut(userId);
    }

    // Endpoint to fetch all activity logs of a specific user
    @GetMapping("/logs/{userId}")
    public List<ActivityLog> getActivityLogsByUser(@PathVariable Long userId) {
        return activityLogService.getActivityLogsByUser(userId);
    }
}
