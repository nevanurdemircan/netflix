package com.example.netflix.mapper;

import com.example.netflix.dto.MoviesSeriesDto;
import com.example.netflix.entity.MoviesSeries;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MoviesSeriesMapper {
    MoviesSeriesMapper INSTANCE = Mappers.getMapper(MoviesSeriesMapper.class);

    MoviesSeriesDto MoviesSeriesToMoviesSeriesDto(MoviesSeries moviesSeries);
}
