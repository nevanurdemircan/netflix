package com.example.netflix.dto;

import com.example.netflix.entity.MoviesSeries;
import com.example.netflix.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WatchHistoryDto {
    private Date watchDate;
    private User user;
    private MoviesSeries moviesSeries;
}
