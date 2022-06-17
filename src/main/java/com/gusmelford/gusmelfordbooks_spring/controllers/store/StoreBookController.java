package com.gusmelford.gusmelfordbooks_spring.controllers.store;

import com.gusmelford.gusmelfordbooks_spring.entities.Book;
import com.gusmelford.gusmelfordbooks_spring.mappers.store.BookMapper;
import com.gusmelford.gusmelfordbooks_spring.mappers.store.GenreMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.BookDto;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.BookInfoDto;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.GenreDto;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/store/book")
@AllArgsConstructor
public class StoreBookController {
    private final StoreBookService storeBookService;
    private final BookMapper bookMapper;

    @PostMapping
    public ResponseEntity<UUID> addBook(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(storeBookService.addBook(bookMapper.fromDto(bookDto)));
    }

    @GetMapping
    public ResponseEntity<BookInfoDto> getBook(@RequestParam UUID bookId){
        return ResponseEntity.ok(bookMapper.toDto(storeBookService.getBook(bookId)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookInfoDto>> getAllGenre(){
        return ResponseEntity.ok(storeBookService.getAllBook().stream().map(bookMapper::toDto).toList());
    }

    @DeleteMapping()
    public void deleteGenre(@RequestParam UUID bookId){
        storeBookService.deleteBook(bookId);
    }

    @PatchMapping()
    public ResponseEntity<UUID> updateGenre(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(storeBookService.updateBook(bookMapper.fromDto(bookDto)));
    }
}
