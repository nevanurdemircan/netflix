package com.example.netflix.controller;

import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.service.WatchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{userId}/watch-history")

public class WatchHistoryController {
    private final WatchHistoryService watchHistoryService;

    @PostMapping("/{moviesSeriesId}")
    public void addToWatchHistory(@PathVariable UUID userId, @PathVariable UUID moviesSeriesId, @RequestParam Date watchedAt) {
        watchHistoryService.addWatchHistory(userId, moviesSeriesId, watchedAt);
    }

    @GetMapping("/getAll")
    public List<MoviesSeriesDto> getUserWatchHistory(@PathVariable UUID userId) {
        return watchHistoryService.getUserWatchHistory(userId);
    }
}
