package com.gusmelford.gusmelfordbooks_spring.services.interfaces.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Genre;

import java.util.List;
import java.util.UUID;

public interface StoreGenreService {
    UUID addGenre(Genre genre);
    Genre getGenre(UUID uuid);
    List<Genre> getAllGenre();
    void deleteGenre(UUID genreId);
    UUID updateGenre(Genre genre);
}
