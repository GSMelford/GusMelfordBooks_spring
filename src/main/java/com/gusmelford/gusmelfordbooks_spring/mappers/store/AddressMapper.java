package com.gusmelford.gusmelfordbooks_spring.mappers.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Address;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddressMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    Address fromDto(AddressDto addressDto);

    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    Address fromDtoWithId(AddressDto addressDto);

    AddressDto toDto(Address address);
}
