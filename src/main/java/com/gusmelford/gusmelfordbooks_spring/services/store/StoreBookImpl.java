package com.gusmelford.gusmelfordbooks_spring.services.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Book;
import com.gusmelford.gusmelfordbooks_spring.entities.Genre;
import com.gusmelford.gusmelfordbooks_spring.entities.Publisher;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.BookData;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.BookInfo;
import com.gusmelford.gusmelfordbooks_spring.repositories.*;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StoreBookImpl implements StoreBookService {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Override
    public UUID addBook(BookData bookData) {
        Book book = new Book();
        book.setAuthor(authorRepository.findById(bookData.getAuthorId()).orElseThrow());
        book.setTitle(bookData.getTitle());
        book.setLanguage(bookData.getLanguage());
        book.setDescription(bookData.getDescription());
        book.setPrice(bookData.getPrice());

        List<Publisher> publishers = new ArrayList<>();
        for (UUID publisherId : bookData.getPublisherIds()){
            Publisher publisher = publisherRepository.findById(publisherId).orElseThrow();
            publishers.add(publisher);
            publisher.getBooks().add(book);
        }

        book.setPublishers(publishers);

        List<Genre> genres = new ArrayList<>();
        for (UUID genreId : bookData.getGenreIds()){
            genres.add(genreRepository.findById(genreId).orElseThrow());
        }

        book.setGenres(genres);
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public BookInfo getBook(UUID bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();

        return new BookInfo(
                book.getId(),
                book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName(),
                book.getTitle(),
                book.getLanguage(),
                book.getDescription(),
                book.getPrice(),
                book.getPublishers().stream().map(Publisher::getName).toString(),
                book.getGenres().stream().map(Genre::getName).toString()
        );
    }

    @Override
    public List<BookInfo> getAllBook() {
        return bookRepository.findAll().stream()
                .map(x -> new BookInfo(
                        x.getId(),
                        x.getAuthor().getFirstName() + " " + x.getAuthor().getLastName(),
                        x.getTitle(),
                        x.getLanguage(),
                        x.getDescription(),
                        x.getPrice(),
                        x.getPublishers().stream().map(Publisher::getName).toString(),
                        x.getGenres().stream().map(Genre::getName).toString()
                )).toList();
    }

    @Override
    public void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public UUID updateBook(BookData bookData) {
        Book fromDbBook = bookRepository.findById(bookData.getId()).orElseThrow();

        fromDbBook.setTitle(bookData.getTitle());
        fromDbBook.setLanguage(bookData.getLanguage());
        fromDbBook.setDescription(bookData.getDescription());
        fromDbBook.setPrice(bookData.getPrice());

        bookRepository.save(fromDbBook);
        return fromDbBook.getId();
    }
}
