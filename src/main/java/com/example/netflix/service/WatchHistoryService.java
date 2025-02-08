package com.example.netflix.service;

import com.example.netflix.converter.MoviesSeriesConverter;
import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import com.example.netflix.entity.WatchHistory;
import com.example.netflix.repository.MoviesSeriesRepository;
import com.example.netflix.repository.UserRepository;
import com.example.netflix.repository.WatchHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WatchHistoryService {
    private final WatchHistoryRepository watchHistoryRepository;
    private final UserRepository userRepository;
    private final MoviesSeriesRepository moviesSeriesRepository;
    private final MoviesSeriesConverter moviesSeriesConverter;

    public void addWatchHistory(UUID userId, UUID moviesSeriesId, Date watchedAt) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("Movies/series not found"));

        WatchHistory watchHistory = new WatchHistory();
        watchHistory.setUser(user);
        watchHistory.setMoviesSeries(moviesSeries);
        watchHistory.setWatchDate(watchedAt);

        watchHistoryRepository.save(watchHistory);
    }

    public List<MoviesSeriesDto> getUserWatchHistory(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<WatchHistory> watchHistoryList = watchHistoryRepository.findByUser(user);

        return watchHistoryList.stream()
                .map(watchHistory -> moviesSeriesConverter.convertToMoviesSeriesDto(watchHistory.getMoviesSeries()))
                .collect(Collectors.toList());
    }
}
