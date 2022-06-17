package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookInfoDto {
    private UUID id;
    private String authorName;
    private String title;
    private String language;
    private String description;
    private Double price;
    private String publishers;
    private String genres;
}
