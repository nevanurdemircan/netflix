package com.example.netflix.service;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.MoviesSeriesComment;
import com.example.netflix.entity.User;
import com.example.netflix.repository.MoviesSeriesCommentRepository;
import com.example.netflix.repository.MoviesSeriesRepository;
import com.example.netflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MoviesSeriesCommentService {
    private final MoviesSeriesCommentRepository moviesSeriesCommentRepository;
    private final UserRepository userRepository;
    private final MoviesSeriesRepository moviesSeriesRepository;

    public MoviesSeriesComment addComment(UUID userId, UUID moviesSeriesId, String comment, double point, boolean spoiler) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("MoviesSeries not found"));

        if (point < 0 || point > 10) {
            throw new RuntimeException("Point must be between 0 and 10");
        }
        MoviesSeriesComment moviesSeriesComment = new MoviesSeriesComment();
        moviesSeriesComment.setUser(user);
        moviesSeriesComment.setMoviesSeries(moviesSeries);
        moviesSeriesComment.setComment(comment);
        moviesSeriesComment.setPoint(point);
        moviesSeriesComment.setSpoiler(spoiler);
        moviesSeriesComment.setCommentDate(new Date());

        return moviesSeriesCommentRepository.save(moviesSeriesComment);
    }

    public List<MoviesSeriesComment> getUserComments(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return moviesSeriesCommentRepository.findByUser(user);
    }

    public List<MoviesSeriesComment> getCommentsForMoviesSeries(UUID moviesSeriesId) {
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId)
                .orElseThrow(() -> new RuntimeException("MoviesSeries not found"));
        return moviesSeriesCommentRepository.findByMoviesSeries(moviesSeries);
    }
}
