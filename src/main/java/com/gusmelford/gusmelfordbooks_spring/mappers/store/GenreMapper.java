package com.gusmelford.gusmelfordbooks_spring.mappers.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Genre;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.GenreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GenreMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "books", ignore = true)
    Genre fromDto(GenreDto genreDto);

    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "books", ignore = true)
    Genre fromDtoWithId(GenreDto genreDto);

    GenreDto toDto(Genre genre);
}
