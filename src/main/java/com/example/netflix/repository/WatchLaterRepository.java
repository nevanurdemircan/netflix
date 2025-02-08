package com.example.netflix.repository;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import com.example.netflix.entity.WatchLater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WatchLaterRepository extends JpaRepository<WatchLater, UUID> {
    WatchLater findByUserAndMoviesSeries(User user, MoviesSeries moviesSeries);

    List<WatchLater> findByUser(User user);
}

