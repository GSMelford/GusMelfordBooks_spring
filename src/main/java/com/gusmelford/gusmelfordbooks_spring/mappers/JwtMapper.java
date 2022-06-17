package com.gusmelford.gusmelfordbooks_spring.mappers;

import com.gusmelford.gusmelfordbooks_spring.payload.dto.JwtDto;
import com.gusmelford.gusmelfordbooks_spring.payload.request.JwtData;
import org.mapstruct.Mapper;

@Mapper
public interface JwtMapper {
    JwtDto toDto(JwtData jwtData);
}
