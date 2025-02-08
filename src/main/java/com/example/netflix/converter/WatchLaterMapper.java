package com.example.netflix.converter;

import com.example.netflix.dto.WatchLaterDto;
import com.example.netflix.entity.WatchLater;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WatchLaterMapper {
    WatchLaterMapper INSTANCE = Mappers.getMapper(WatchLaterMapper.class);

    WatchLaterDto watchLaterToWatchLaterDto(WatchLater watchLater);
}
