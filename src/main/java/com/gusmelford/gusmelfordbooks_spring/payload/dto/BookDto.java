package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class BookDto {
    private UUID id;
    private UUID authorId;
    private String title;
    private String language;
    private String description;
    private Double price;
    private List<UUID> publisherIds;
    private List<UUID> genreIds;
}
