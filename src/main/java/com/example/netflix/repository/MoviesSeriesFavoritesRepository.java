package com.example.netflix.repository;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.MoviesSeriesFavorites;
import com.example.netflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MoviesSeriesFavoritesRepository extends JpaRepository<MoviesSeriesFavorites, UUID> {
    MoviesSeriesFavorites findByUserAndMoviesSeries(User user, MoviesSeries moviesSeries);

    List<MoviesSeriesFavorites> findByUser(User user);
}
