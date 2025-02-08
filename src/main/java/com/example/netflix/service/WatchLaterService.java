package com.example.netflix.service;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import com.example.netflix.entity.WatchLater;
import com.example.netflix.repository.MoviesSeriesRepository;
import com.example.netflix.repository.UserRepository;
import com.example.netflix.repository.WatchLaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WatchLaterService {
    private final WatchLaterRepository watchLaterRepository;
    private final UserRepository userRepository;
    private final MoviesSeriesRepository moviesSeriesRepository;

    public void watchLaterAdd(UUID userId, UUID moviesSeriesId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("Movies/Series Not Found"));

        WatchLater watchLater = new WatchLater();
        watchLater.setUser(user);
        watchLater.setMoviesSeries(moviesSeries);
        watchLaterRepository.save(watchLater);
    }

    public List<MoviesSeries> getWatchLaterList(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        List<WatchLater> watchLaterList = watchLaterRepository.findByUser(user);
        return watchLaterList.stream()
                .map(WatchLater::getMoviesSeries)
                .collect(Collectors.toList());
    }

    public void removeFromWatchLater(UUID userId, UUID moviesSeriesId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("Movies/Series not found"));
        WatchLater watchLater = watchLaterRepository.findByUserAndMoviesSeries(user, moviesSeries);

        watchLaterRepository.delete(watchLater);
    }
}

