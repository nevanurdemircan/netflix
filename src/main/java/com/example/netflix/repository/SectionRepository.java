package com.example.netflix.repository;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SectionRepository extends JpaRepository<Section, UUID> {
    List<Section> findByMoviesSeries(MoviesSeries moviesSeries);
}
