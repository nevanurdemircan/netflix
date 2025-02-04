package com.example.netflix.repository;

import com.example.netflix.entity.UserFavorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserFavoritesRepository extends JpaRepository<UserFavorites, UUID> {
}
