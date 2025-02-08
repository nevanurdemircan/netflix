package com.example.netflix.repository;

import com.example.netflix.entity.User;
import com.example.netflix.entity.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory, UUID> {
    List<WatchHistory> findByUser(User user);
}
