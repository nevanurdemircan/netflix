package com.example.netflix.converter;

import com.example.netflix.dto.SectionDto;
import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.Section;
import com.example.netflix.repository.MoviesSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SectionConverter {
    private final MoviesSeriesRepository moviesSeriesRepository;
    public SectionDto convertToDto(Section section) {
        SectionDto sectionDto = new SectionDto();
        sectionDto.setTitle(section.getTitle());
        sectionDto.setDescription(section.getDescription());
        sectionDto.setReleaseDate(section.getReleaseDate());
        sectionDto.setEpisodeNumber(section.getEpisodeNumber());
        sectionDto.setDuration(section.getDuration());
        sectionDto.setImageUrl(section.getImageUrl());
        sectionDto.setMoviesSeries(section.getMoviesSeries());
        return sectionDto;
    }

    public Section convertToEntity(SectionDto sectionDto) {
        Section section = new Section();
        section.setTitle(sectionDto.getTitle());
        section.setDescription(sectionDto.getDescription());
        section.setReleaseDate(sectionDto.getReleaseDate());
        section.setEpisodeNumber(sectionDto.getEpisodeNumber());
        section.setDuration(sectionDto.getDuration());
        section.setImageUrl(sectionDto.getImageUrl());

        MoviesSeries moviesSeries = moviesSeriesRepository.findById(sectionDto.getMoviesSeries().getUuid())
                .orElseThrow(() -> new RuntimeException("MoviesSeries not found"));
        section.setMoviesSeries(moviesSeries);

        return section;
    }
}
