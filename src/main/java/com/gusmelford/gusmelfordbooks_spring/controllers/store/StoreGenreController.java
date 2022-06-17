package com.gusmelford.gusmelfordbooks_spring.controllers.store;

import com.gusmelford.gusmelfordbooks_spring.mappers.store.GenreMapper;
import com.gusmelford.gusmelfordbooks_spring.payload.dto.GenreDto;
import com.gusmelford.gusmelfordbooks_spring.services.interfaces.store.StoreGenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/store/genre")
@AllArgsConstructor
public class StoreGenreController {
    private final StoreGenreService storeGenreService;
    private final GenreMapper genreMapper;

    @PostMapping
    public ResponseEntity<UUID> addGenre(@RequestBody GenreDto genreDto){
        return ResponseEntity.ok(storeGenreService.addGenre(genreMapper.fromDto(genreDto)));
    }

    @GetMapping
    public ResponseEntity<GenreDto> getGenre(@RequestParam UUID genreId){
        return ResponseEntity.ok(genreMapper.toDto(storeGenreService.getGenre(genreId)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenreDto>> getAllGenre(){
        return ResponseEntity.ok(storeGenreService.getAllGenre().stream().map(genreMapper::toDto).toList());
    }

    @DeleteMapping()
    public void deleteGenre(@RequestParam UUID genreId){
        storeGenreService.deleteGenre(genreId);
    }

    @PatchMapping()
    public ResponseEntity<UUID>updateGenre(@RequestBody GenreDto genreDto){
        return ResponseEntity.ok(storeGenreService.updateGenre(genreMapper.fromDtoWithId(genreDto)));
    }
}
