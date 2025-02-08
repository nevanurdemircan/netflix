package com.example.netflix.controller;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.service.WatchLaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/watch-later")
public class WatchLaterController {
    private final WatchLaterService watchLaterService;

    @PostMapping("/{userId}/{moviesSeriesId}")
    public void addToWatchLater(@PathVariable UUID userId, @PathVariable UUID moviesSeriesId) {
        watchLaterService.watchLaterAdd(userId, moviesSeriesId);
    }

    @GetMapping("/get/{userId}")
    public List<MoviesSeries> getWatchLaterList(@PathVariable UUID userId) {
        return watchLaterService.getWatchLaterList(userId);
    }

    @DeleteMapping("/{userId}/{moviesSeriesId}")
    public void removeFromWatchLater(@PathVariable UUID userId, @PathVariable UUID moviesSeriesId) {
        watchLaterService.removeFromWatchLater(userId, moviesSeriesId);
    }
}
