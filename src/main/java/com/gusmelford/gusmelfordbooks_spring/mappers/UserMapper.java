package com.gusmelford.gusmelfordbooks_spring.mappers;

import com.gusmelford.gusmelfordbooks_spring.entities.User;
import com.gusmelford.gusmelfordbooks_spring.payload.request.UserRegistrationData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "role", ignore = true)
    User fromDto(UserRegistrationData registerRequest);
}
