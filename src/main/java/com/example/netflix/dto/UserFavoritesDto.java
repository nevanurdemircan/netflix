package com.example.netflix.dto;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFavoritesDto {
    private User user;
    private MoviesSeries movieSeries;
}
