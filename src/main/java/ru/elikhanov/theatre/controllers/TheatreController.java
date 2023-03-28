package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.TheatreDTO;
import ru.elikhanov.theatre.services.impl.TheatreServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru/theatres")
public class TheatreController {

    private final TheatreServiceImpl theatreService;

    @GetMapping()
    public ResponseEntity<List<TheatreDTO>> getAllCities() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<TheatreDTO> getCityById(
            @PathVariable("theatreId") Long theatreId
    ) {
        return ResponseEntity.ok(theatreService.getTheatreById(theatreId));
    }

    @PostMapping()
    public ResponseEntity<Long> createCity(
            @RequestBody @Valid TheatreDTO TheatreDTO

    ) {
        return new ResponseEntity<>(theatreService.createTheatre(TheatreDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{theatreId}")
    public ResponseEntity<TheatreDTO> updateCity(
            @PathVariable("theatreId") Long theatreId,
            @RequestBody @Valid TheatreDTO TheatreDTO
    ) {
        return new ResponseEntity<>(theatreService.updateTheatre(theatreId, TheatreDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{theatreId}")
    public ResponseEntity<?> deleteTheatre(@PathVariable("theatreId") Long theatreId) {
        theatreService.deleteTheatre(theatreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
