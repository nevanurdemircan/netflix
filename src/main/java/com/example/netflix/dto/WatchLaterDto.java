package com.example.netflix.dto;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchLaterDto {
    private User user;
    private MoviesSeries moviesSeries;
}
