package com.gusmelford.gusmelfordbooks_spring.services.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Author;
import com.gusmelford.gusmelfordbooks_spring.entities.Genre;
import com.gusmelford.gusmelfordbooks_spring.repositories.AuthorRepository;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class StoreAuthorServiceImpl implements StoreAuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public UUID addAuthor(Author author) {
        authorRepository.save(author);
        return author.getId();
    }

    @Override
    public Author getAuthor(UUID authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll().stream().toList();
    }

    @Override
    public void deleteAuthor(UUID authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public UUID updateAuthor(Author author) {
        Author fromDbAuthor = authorRepository.findById(author.id).orElseThrow();
        fromDbAuthor.setFirstName(author.getFirstName());
        fromDbAuthor.setMiddleName(author.getMiddleName());
        fromDbAuthor.setLastName(author.getLastName());
        fromDbAuthor.setDateOfBirth(author.getDateOfBirth());
        authorRepository.save(fromDbAuthor);
        return fromDbAuthor.getId();
    }
}
