package com.example.netflix.service;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.MoviesSeriesFavorites;
import com.example.netflix.entity.User;
import com.example.netflix.repository.MoviesSeriesFavoritesRepository;
import com.example.netflix.repository.MoviesSeriesRepository;
import com.example.netflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MoviesSeriesFavoriteService {
    private final MoviesSeriesFavoritesRepository moviesSeriesFavoritesRepository;
    private final UserRepository userRepository;
    private final MoviesSeriesRepository moviesSeriesRepository;

    public void addToFavorite(UUID userId, UUID moviesSeriesId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("Movies/Series Not Found"));

        MoviesSeriesFavorites existingFavorite = moviesSeriesFavoritesRepository.findByUserAndMoviesSeries(user, moviesSeries);
        if (existingFavorite != null) {
            existingFavorite.setFavorites(true);
            moviesSeriesFavoritesRepository.save(existingFavorite);
        } else {
            MoviesSeriesFavorites moviesSeriesFavorites = new MoviesSeriesFavorites();
            moviesSeriesFavorites.setUser(user);
            moviesSeriesFavorites.setMoviesSeries(moviesSeries);
            moviesSeriesFavorites.setFavorites(true);
            moviesSeriesFavoritesRepository.save(moviesSeriesFavorites);
        }
    }

    public List<MoviesSeriesFavorites> getAll(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return moviesSeriesFavoritesRepository.findByUser(user);
    }

}
