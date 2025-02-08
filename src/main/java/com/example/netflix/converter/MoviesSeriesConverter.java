package com.example.netflix.converter;

import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.entity.MoviesSeries;
import org.springframework.stereotype.Component;

@Component
public class MoviesSeriesConverter {
    public MoviesSeries convertToMoviesSeries(MoviesSeriesDto moviesSeriesDto) {
        MoviesSeries moviesSeries = new MoviesSeries();
        moviesSeries.setTitle(moviesSeriesDto.getTitle());
        moviesSeries.setDescription(moviesSeriesDto.getDescription());
        moviesSeries.setType(moviesSeriesDto.getType());
        moviesSeries.setSections(moviesSeriesDto.getSections());
        moviesSeries.setImageUrl(moviesSeriesDto.getImageUrl());
        moviesSeries.setImdbRating(moviesSeriesDto.getImdbRating());
        moviesSeries.setReleaseDate(moviesSeriesDto.getReleaseDate());
        moviesSeries.setUserRating(moviesSeriesDto.getUserRating());
        moviesSeries.setImdbRating(moviesSeriesDto.getImdbRating());
        moviesSeries.setTrailerUrl(moviesSeriesDto.getTrailerUrl());

        return moviesSeries;
    }

    public MoviesSeriesDto convertToMoviesSeriesDto(MoviesSeries moviesSeries) {
        MoviesSeriesDto moviesSeriesDto = new MoviesSeriesDto();
        moviesSeriesDto.setTitle(moviesSeries.getTitle());
        moviesSeriesDto.setDescription(moviesSeries.getDescription());
        moviesSeriesDto.setType(moviesSeries.getType());
        moviesSeriesDto.setSections(moviesSeries.getSections());
        moviesSeriesDto.setImageUrl(moviesSeries.getImageUrl());
        moviesSeriesDto.setImdbRating(moviesSeries.getImdbRating());
        moviesSeriesDto.setReleaseDate(moviesSeries.getReleaseDate());
        moviesSeriesDto.setUserRating(moviesSeries.getUserRating());
        moviesSeriesDto.setImdbRating(moviesSeries.getImdbRating());
        moviesSeriesDto.setTrailerUrl(moviesSeries.getTrailerUrl());
        return moviesSeriesDto;
    }
}
