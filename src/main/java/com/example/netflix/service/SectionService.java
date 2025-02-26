package com.example.netflix.service;

import com.example.netflix.converter.SectionConverter;
import com.example.netflix.dto.SectionDto;
import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.Section;
import com.example.netflix.repository.MoviesSeriesRepository;
import com.example.netflix.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SectionService {
    private final SectionRepository sectionRepository;
    private final MoviesSeriesRepository moviesSeriesRepository;
    private final SectionConverter sectionConverter;

    public SectionDto addSection(UUID moviesSeriesId, SectionDto sectionDto) {
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("MoviesSeries not found"));
        Section section = sectionConverter.convertToEntity(sectionDto);
        section.setMoviesSeries(moviesSeries);
        Section savedSection = sectionRepository.save(section);
        return sectionConverter.convertToDto(savedSection);
    }

    public List<Section> getSectionsByMoviesSeries(UUID moviesSeriesId) {
        MoviesSeries moviesSeries = moviesSeriesRepository.findById(moviesSeriesId).orElseThrow(() -> new RuntimeException("MoviesSeries not found"));
        return sectionRepository.findByMoviesSeries(moviesSeries);
    }
}
