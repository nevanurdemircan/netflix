package com.example.netflix.controller;

import com.example.netflix.entity.MoviesSeriesComment;
import com.example.netflix.service.MoviesSeriesCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies-series-comment")
public class MoviesSeriesCommentController {
    private final MoviesSeriesCommentService moviesSeriesCommentService;

    @PostMapping("/{userId}/{moviesSeriesId}")
    public MoviesSeriesComment addComment(@PathVariable UUID userId, @PathVariable UUID moviesSeriesId, @RequestParam String comment, @RequestParam double point, @RequestParam boolean spoiler) {
        return moviesSeriesCommentService.addComment(userId, moviesSeriesId, comment, point, spoiler);
    }

    @GetMapping("/user/{userId}")
    public List<MoviesSeriesComment> getUserComments(@PathVariable UUID userId) {
        return moviesSeriesCommentService.getUserComments(userId);
    }

    @PostMapping("/movies-series{moviesSeriesId}")
    public List<MoviesSeriesComment> getCommentsForMoviesSeries(@PathVariable UUID moviesSeriesId) {
        return moviesSeriesCommentService.getCommentsForMoviesSeries(moviesSeriesId);
    }
}
