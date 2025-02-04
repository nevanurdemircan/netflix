package com.example.netflix.dto;

import com.example.netflix.entity.MoviesSeries;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SectionDto {
    private String title;
    private String description;
    private Date releaseDate;
    private int episodeNumber;
    private int duration;
    private String imageUrl;
    private MoviesSeries moviesSeries;
}
