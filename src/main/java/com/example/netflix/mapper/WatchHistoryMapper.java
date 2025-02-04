package com.example.netflix.mapper;

import com.example.netflix.dto.WatchHistoryDto;
import com.example.netflix.entity.WatchHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WatchHistoryMapper {
    WatchHistoryMapper INSTANCE = Mappers.getMapper(WatchHistoryMapper.class);

    WatchHistoryDto watchHistoryTowatchHistoryDto(WatchHistory watchHistory);
}
