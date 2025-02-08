package com.example.netflix.converter;

import com.example.netflix.dto.SectionDto;
import com.example.netflix.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SectionMapper {
    SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);

    SectionDto sectionToSectionDto(Section section);
}
