package com.example.netflix.dto;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MoviesSeriesCommentDto {
    private String comment;
    private double point;
    private Date commentDate;
    private boolean spoiler;
    private User user;
    private MoviesSeries moviesSeries;
}
