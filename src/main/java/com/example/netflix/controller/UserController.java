package com.example.netflix.controller;

import com.example.netflix.dto.UserDto;
import com.example.netflix.entity.MoviesSeriesFavorites;
import com.example.netflix.entity.User;
import com.example.netflix.service.MoviesSeriesFavoriteService;
import com.example.netflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")

public class UserController {
    private final MoviesSeriesFavoriteService moviesSeriesFavoriteService;
    private final UserService userService;

    @GetMapping("/favorites/{userId}")
    public List<MoviesSeriesFavorites> getUserFavorites(@PathVariable UUID userId) {
        return moviesSeriesFavoriteService.getAll(userId);
    }

    @PostMapping("/save")
    public User save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/{userId}/favorites/{moviesSeriesId}")
    public void addToFavorites(@PathVariable UUID userId, @PathVariable UUID moviesSeriesId) {
        moviesSeriesFavoriteService.addToFavorite(userId, moviesSeriesId);
    }
}
