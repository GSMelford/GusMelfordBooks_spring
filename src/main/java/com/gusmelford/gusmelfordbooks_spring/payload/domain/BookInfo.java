package com.gusmelford.gusmelfordbooks_spring.payload.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookInfo {
    private UUID id;
    private String authorName;
    private String title;
    private String language;
    private String description;
    private Double price;
    private String publishers;
    private String genres;

    public BookInfo(UUID id, String authorName, String title, String language, String description, Double price, String publishers, String genres) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.language = language;
        this.description = description;
        this.price = price;
        this.publishers = publishers;
        this.genres = genres;
    }
}
