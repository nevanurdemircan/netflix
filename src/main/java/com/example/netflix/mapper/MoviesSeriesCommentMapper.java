package com.example.netflix.mapper;

import com.example.netflix.dto.MoviesSeriesCommentDto;
import com.example.netflix.entity.MoviesSeriesComment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MoviesSeriesCommentMapper {
    MoviesSeriesCommentMapper INSTANCE = Mappers.getMapper(MoviesSeriesCommentMapper.class);
    MoviesSeriesCommentDto MoviesSeriesCommentToMoviesSeriesCommentDto(MoviesSeriesComment moviesSeriesComment);
}
