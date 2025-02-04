package com.example.netflix.dto;

import com.example.netflix.entity.Section;
import com.example.netflix.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MoviesSeriesDto {
    private String title;
    private String description;
    private Genre type;
    private String releaseDate;
    private double imdbRating;
    private double userRating;
    private String trailerUrl;
    private String imageUrl;
    private List<Section> sections;
}
