package com.example.netflix.repository;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.MoviesSeriesComment;
import com.example.netflix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MoviesSeriesCommentRepository extends JpaRepository<MoviesSeriesComment, UUID> {
    List<MoviesSeriesComment> findByUser(User user);
    List<MoviesSeriesComment> findByMoviesSeries(MoviesSeries moviesSeries);
}
