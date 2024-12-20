package com.example.oop_final.repository;

import com.example.oop_final.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    List<ActivityLog> findByUserId(Long userId);
    Optional<ActivityLog> findTopByUserIdOrderByCheckInTimeDesc(Long userId);
}
