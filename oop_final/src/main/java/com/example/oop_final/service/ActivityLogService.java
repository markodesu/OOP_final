package com.example.oop_final.service;

import com.example.oop_final.model.ActivityLog;
import com.example.oop_final.model.User;
import com.example.oop_final.repository.ActivityLogRepository;
import com.example.oop_final.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private UserRepository userRepository;

    // Member check-in logic
    public ActivityLog checkIn(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        ActivityLog log = new ActivityLog();
        log.setUser(user);
        log.setCheckInTime(LocalDateTime.now());

        return activityLogRepository.save(log);
    }

    // Member check-out logic
    public ActivityLog checkOut(Long userId) {
        // Find the last activity log for the user
        ActivityLog log = activityLogRepository.findTopByUserIdOrderByCheckInTimeDesc(userId)
                .orElseThrow(() -> new IllegalArgumentException("No active check-in found for the user"));

        log.setCheckOutTime(LocalDateTime.now());
        return activityLogRepository.save(log);
    }

    // Retrieve all activity logs for a user
    public List<ActivityLog> getActivityLogsByUser(Long userId) {
        return activityLogRepository.findByUserId(userId);
    }
}
