package com.example.netflix.controller;

import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.converter.MoviesSeriesConverter;
import com.example.netflix.service.MoviesSeriesService;
import com.example.netflix.service.WatchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies-series")
@RequiredArgsConstructor
public class MoviesSeriesController {
    private final MoviesSeriesService moviesSeriesService;
    private final MoviesSeriesConverter moviesSeriesConverter;
    private final WatchHistoryService watchHistoryService;

    @PostMapping("/save")
    public MoviesSeriesDto save(@RequestBody MoviesSeriesDto moviesSeriesDto) {
        MoviesSeries save = moviesSeriesService.save(moviesSeriesDto);
        return moviesSeriesConverter.convertToMoviesSeriesDto(save);
    }

    @PutMapping("/update/{moviesSeriesId}")
    public MoviesSeriesDto update(@PathVariable UUID moviesSeriesId, @RequestBody MoviesSeriesDto moviesSeriesDto) {
        return moviesSeriesService.update(moviesSeriesId, moviesSeriesDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        moviesSeriesService.delete(id);
    }

    @PostMapping("/{moviesSeriesId}/watch/{userId}")
    public void watchMovie(@PathVariable UUID moviesSeriesId, @PathVariable UUID userId, @RequestParam Date watchedAt) {
        watchHistoryService.addWatchHistory(userId, moviesSeriesId, watchedAt);
    }

    @GetMapping("/getAll")
    public List<MoviesSeries> getAll() {
        return moviesSeriesService.getAll();
    }
}
