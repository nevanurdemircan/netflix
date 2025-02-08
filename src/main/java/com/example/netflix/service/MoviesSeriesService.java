package com.example.netflix.service;

import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.mapper.MoviesSeriesConverter;
import com.example.netflix.repository.MoviesSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MoviesSeriesService {
    private final MoviesSeriesRepository moviesSeriesRepository;
    private final MoviesSeriesConverter converter;

    public MoviesSeries save(MoviesSeriesDto moviesSeriesDto) {
        MoviesSeries moviesSeries = converter.convertToMoviesSeries(moviesSeriesDto);
        return moviesSeriesRepository.save(moviesSeries);
    }

    public MoviesSeriesDto update(UUID moviesSeriesId, MoviesSeriesDto moviesSeriesDto) {

        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId)
                .orElseThrow(() -> new RuntimeException("Movies Series Id not found"));

        moviesSeries.setTitle(moviesSeriesDto.getTitle());
        moviesSeries.setDescription(moviesSeriesDto.getDescription());
        moviesSeries.setType(moviesSeriesDto.getType());
        moviesSeries.setSections(moviesSeriesDto.getSections());
        moviesSeries.setImageUrl(moviesSeriesDto.getImageUrl());
        moviesSeries.setImdbRating(moviesSeriesDto.getImdbRating());
        moviesSeries.setReleaseDate(moviesSeriesDto.getReleaseDate());
        moviesSeries.setUserRating(moviesSeriesDto.getUserRating());
        moviesSeries.setTrailerUrl(moviesSeriesDto.getTrailerUrl());

        MoviesSeries updatedMoviesSeries = moviesSeriesRepository.save(moviesSeries);

        return converter.convertToMoviesSeriesDto(updatedMoviesSeries);
    }

    public void delete(UUID moviesSeriesId) {
        moviesSeriesRepository.deleteById(moviesSeriesId);
    }
}
