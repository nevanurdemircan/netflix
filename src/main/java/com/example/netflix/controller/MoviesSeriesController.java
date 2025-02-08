package com.example.netflix.controller;

import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.mapper.MoviesSeriesConverter;
import com.example.netflix.service.MoviesSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/movies-series")
@RequiredArgsConstructor
public class MoviesSeriesController {
    private final MoviesSeriesService moviesSeriesService;
    private final MoviesSeriesConverter moviesSeriesConverter;

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
    public void delete(@PathVariable UUID id){
        moviesSeriesService.delete( id);
    }
}
