package com.gusmelford.gusmelfordbooks_spring.services.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Genre;
import com.gusmelford.gusmelfordbooks_spring.repositories.GenreRepository;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreGenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class StoreGenreServiceImpl implements StoreGenreService {
    private final GenreRepository genreRepository;

    @Override
    public UUID addGenre(Genre genre) {
        genreRepository.save(genre);
        return genre.getId();
    }

    @Override
    public Genre getGenre(UUID genreId) {
        return genreRepository.findById(genreId).orElseThrow();
    }

    @Override
    public List<Genre> getAllGenre() {
        return StreamSupport.stream(genreRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public void deleteGenre(UUID genreId) {
        genreRepository.deleteById(genreId);
    }

    @Override
    public UUID updateGenre(Genre genre) {
        Genre fromDbGenre = genreRepository.findById(genre.id).orElseThrow();
        fromDbGenre.setName(genre.getName());
        fromDbGenre.setDescription(genre.getDescription());
        genreRepository.save(fromDbGenre);
        return fromDbGenre.getId();
    }
}
