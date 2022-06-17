package com.gusmelford.gusmelfordbooks_spring.services.interfaces.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Author;

import java.util.List;
import java.util.UUID;

public interface StoreAuthorService {
    UUID addAuthor(Author author);
    Author getAuthor(UUID authorId);
    List<Author> getAllAuthor();
    void deleteAuthor(UUID authorId);
    UUID updateAuthor(Author author);
}
