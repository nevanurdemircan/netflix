package com.example.netflix.converter;

import com.example.netflix.dto.UserFavoritesDto;
import com.example.netflix.entity.UserFavorites;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserFavoritesMapper {
    UserFavoritesMapper INSTANCE = Mappers.getMapper(UserFavoritesMapper.class);

    UserFavoritesDto userFavoritesToUserFavoritesDto(UserFavorites userFavorites);
}
