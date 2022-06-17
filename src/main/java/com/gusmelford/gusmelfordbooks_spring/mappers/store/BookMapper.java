package com.gusmelford.gusmelfordbooks_spring.mappers.store;

import com.gusmelford.gusmelfordbooks_spring.payload.domain.BookData;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.BookInfo;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.BookDto;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.BookInfoDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookData fromDto(BookDto bookDto);
    BookInfoDto toDto(BookInfo bookInfo);
}
