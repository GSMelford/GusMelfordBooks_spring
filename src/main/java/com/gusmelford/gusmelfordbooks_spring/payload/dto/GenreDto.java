package com.gusmelford.gusmelfordbooks_spring.payload.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GenreDto {
    private UUID id;
    private String name;
    private String description;
}
