package com.gusmelford.gusmelfordbooks_spring.payload.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BookData {
    private UUID id;
    private UUID authorId;
    private String title;
    private String language;
    private String description;
    private Double price;
    private List<UUID> publisherIds;
    private List<UUID> genreIds;
}
