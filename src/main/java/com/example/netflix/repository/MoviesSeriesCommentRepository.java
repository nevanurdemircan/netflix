package com.example.netflix.repository;

import com.example.netflix.entity.MoviesSeriesComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoviesSeriesCommentRepository extends JpaRepository<MoviesSeriesComment, UUID> {
}
