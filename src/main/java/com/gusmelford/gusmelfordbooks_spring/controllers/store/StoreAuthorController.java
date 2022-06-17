package com.gusmelford.gusmelfordbooks_spring.controllers.store;

import com.gusmelford.gusmelfordbooks_spring.mappers.store.AuthorMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.AuthorDto;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/store/author")
@AllArgsConstructor
public class StoreAuthorController {
    private final StoreAuthorService storeAuthorService;
    private final AuthorMapper authorMapper;

    @PostMapping
    public ResponseEntity<UUID> addAuthor(@RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(storeAuthorService.addAuthor(authorMapper.fromDto(authorDto)));
    }

    @GetMapping
    public ResponseEntity<AuthorDto> getAuthor(@RequestParam UUID authorId){
        return ResponseEntity.ok(authorMapper.toDto(storeAuthorService.getAuthor(authorId)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDto>> getAllGenre(){
        return ResponseEntity.ok(storeAuthorService.getAllAuthor().stream().map(authorMapper::toDto).toList());
    }

    @DeleteMapping()
    public void deleteGenre(@RequestParam UUID authorId){
        storeAuthorService.deleteAuthor(authorId);
    }

    @PatchMapping()
    public ResponseEntity<UUID> updateGenre(@RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(storeAuthorService.updateAuthor(authorMapper.fromDtoWithId(authorDto)));
    }
}
