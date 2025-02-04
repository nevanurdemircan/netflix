package com.example.netflix.repository;

import com.example.netflix.entity.WatchLater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WatchLaterRepository extends JpaRepository<WatchLater, UUID> {
}
