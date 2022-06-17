package com.gusmelford.gusmelfordbooks_spring.mappers.shop;

import com.gusmelford.gusmelfordbooks_spring.payload.domain.UserBook;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.UserBookDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserBookMapper {
    UserBookDto toDto(UserBook userBook);
}
