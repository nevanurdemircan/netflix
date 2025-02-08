package com.example.netflix.converter;

import com.example.netflix.dto.MoviesSeriesFavoritesDto;
import com.example.netflix.entity.MoviesSeriesFavorites;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface MoviesSeriesFavoriteMapper{
    MoviesSeriesFavoriteMapper INSTANCE = Mappers.getMapper(MoviesSeriesFavoriteMapper.class);
    MoviesSeriesFavoritesDto MoviesSeriesFavoritesToMoviesSeriesFavoritesDto(MoviesSeriesFavorites moviesSeriesFavorites);
}
