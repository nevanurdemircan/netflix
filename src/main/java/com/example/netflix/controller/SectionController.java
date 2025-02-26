package com.example.netflix.controller;

import com.example.netflix.dto.SectionDto;
import com.example.netflix.entity.Section;
import com.example.netflix.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/section")
@RequiredArgsConstructor
public class SectionController {
    private final SectionService sectionService;

    @PostMapping("/{moviesSeriesId}")
    public SectionDto addSection(@PathVariable UUID moviesSeriesId, @RequestBody SectionDto sectionDto) {
        sectionDto.setMoviesSeries(sectionDto.getMoviesSeries());
        return sectionService.addSection(moviesSeriesId, sectionDto);
    }

    @GetMapping("/{moviesSeriesId}")
    public List<Section> getSectionsByMoviesSeries(@PathVariable UUID moviesSeriesId) {
        return sectionService.getSectionsByMoviesSeries(moviesSeriesId);
    }
}
