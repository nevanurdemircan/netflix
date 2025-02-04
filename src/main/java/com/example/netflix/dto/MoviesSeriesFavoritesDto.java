package com.example.netflix.dto;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoviesSeriesFavoritesDto {
    private boolean favorites;
    private User user;
    private MoviesSeries moviesSeries;
}
