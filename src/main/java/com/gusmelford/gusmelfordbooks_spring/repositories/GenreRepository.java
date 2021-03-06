package com.gusmelford.gusmelfordbooks_spring.repositories;

import com.gusmelford.gusmelfordbooks_spring.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends CrudRepository<Genre, UUID> {
}
