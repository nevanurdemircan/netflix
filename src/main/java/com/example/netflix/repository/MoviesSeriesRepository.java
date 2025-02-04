package com.example.netflix.repository;

import com.example.netflix.entity.MoviesSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoviesSeriesRepository extends JpaRepository<MoviesSeries, UUID> {
}
