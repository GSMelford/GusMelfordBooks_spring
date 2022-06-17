package com.gusmelford.gusmelfordbooks_spring.mappers.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Publisher;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.PublisherData;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.PublisherInfo;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.PublisherDto;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.PublisherInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PublisherMapper {
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "books", ignore = true)
    Publisher fromDtoWithId(PublisherDto publisherDto);

    PublisherData fromDto(PublisherDto publisherDto);

    PublisherInfoDto toDto(PublisherInfo publisherInfo);
}
