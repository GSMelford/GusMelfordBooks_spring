package com.gusmelford.gusmelfordbooks_spring.mappers.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Author;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author fromDto(AuthorDto authorDto);

    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    Author fromDtoWithId(AuthorDto authorDto);

    AuthorDto toDto(Author author);
}
