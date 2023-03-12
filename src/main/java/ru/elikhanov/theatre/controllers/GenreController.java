package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.GenreDTO;
import ru.elikhanov.theatre.services.impl.GenreServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru/genres")
public class GenreController {
    private final GenreServiceImpl genreService;

    @GetMapping()
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/{genreId}")
    public ResponseEntity<GenreDTO> getGenreById(
            @PathVariable("genreId") Long genreId
    ) {
        return ResponseEntity.ok(genreService.getGenreById(genreId));
    }


    @PostMapping()
    public ResponseEntity<GenreDTO> createGenre(
            @RequestBody @Valid GenreDTO genreDTO

    ) {
        return new ResponseEntity<>(genreService.createGenre(genreDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{genreId}")
    public ResponseEntity<GenreDTO> updateCity(
            @PathVariable("genreId") Long genreId,
            @RequestBody @Valid GenreDTO genreDTO

    ) {

        return new ResponseEntity<>(genreService.updateGenre(genreId, genreDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{genreId}")
    public ResponseEntity<?> deleteCity(@PathVariable("genreId") Long genreId) {
        genreService.deleteGenre(genreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
