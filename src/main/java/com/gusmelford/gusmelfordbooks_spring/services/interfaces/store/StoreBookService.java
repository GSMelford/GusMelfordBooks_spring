package com.gusmelford.gusmelfordbooks_spring.services.interfaces.store;

import com.gusmelford.gusmelfordbooks_spring.payload.domain.BookData;
import com.gusmelford.gusmelfordbooks_spring.payload.domain.BookInfo;

import java.util.List;
import java.util.UUID;

public interface StoreBookService {
    UUID addBook(BookData bookData);
    BookInfo getBook(UUID bookId);
    List<BookInfo> getAllBook();
    void deleteBook(UUID bookId);
    UUID updateBook(BookData bookData);
}
