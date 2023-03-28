package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.HallDTO;
import ru.elikhanov.theatre.services.impl.HallServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru")

public class HallController {

    private final HallServiceImpl hallService;

    @GetMapping("/{theatreId}/halls")
    public ResponseEntity<List<HallDTO>> getHallsByTheatre(
            @PathVariable("theatreId") Long theatreId
    ) {
        return ResponseEntity.ok(hallService.getHallsByTheatre(theatreId));
    }

    @GetMapping("/halls/{hallId}")
    public ResponseEntity<HallDTO> getCityById(
            @PathVariable("hallId") Long hallId
    ) {
        return ResponseEntity.ok(hallService.getHallById(hallId));
    }

    @PostMapping("/{theatreId}/halls")
    public ResponseEntity<Long> addHallInTheTheatre(
            @PathVariable("theatreId") Long theatreId,
            @RequestBody @Valid HallDTO hallDTO

    ) {

        return new ResponseEntity<>(hallService.createHall(theatreId, hallDTO), HttpStatus.CREATED);
    }

    @PutMapping("/halls/{hallId}")
    public ResponseEntity<HallDTO> updateHall(
            @PathVariable("hallId") Long hallId,
            @RequestBody @Valid HallDTO hallDTO

    ) {

        return new ResponseEntity<>(hallService.updateHall(hallId, hallDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("halls/{hallId}")
    public ResponseEntity<?> deleteHall(@PathVariable("hallId") Long hallId) {
        hallService.deleteHall(hallId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
