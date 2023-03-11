package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.HallDTO;
import ru.elikhanov.theatre.exceptions.CheckError;
import ru.elikhanov.theatre.services.impl.HallServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru")

public class HallController {

    private final HallServiceImpl hallService;
    private final CheckError checkError = new CheckError();


    @GetMapping("/{theatreId}/halls")
    public ResponseEntity<List<HallDTO>> getHallsByTheatre(
            @PathVariable("theatreId") Long theatreId
    ) {

        return ResponseEntity.ok(hallService.getHallsByTheatre(theatreId));
    }



    @PostMapping("/{theatreId}/halls")
    public ResponseEntity<HallDTO> addHallInTheTheatre(
            @PathVariable("theatreId") Long theatreId,
            @RequestBody @Valid HallDTO hallDTO,
            BindingResult bindingResult
    ) {
        CheckError.checkError(bindingResult, "Ошибка при вводе данных: ");
        return new ResponseEntity<>(hallService.createHall(theatreId, hallDTO), HttpStatus.CREATED);
    }

    @PutMapping("halls/{hallId}")
    public ResponseEntity<HallDTO> updateHall(
            @PathVariable("hallId") Long hallId,
            @RequestBody @Valid HallDTO hallDTO,
            BindingResult bindingResult
    ) {
       CheckError.checkError(bindingResult, "Ошибка при вводе данных: ");
        hallService.updateHall(hallId, hallDTO);
        return new ResponseEntity<>(hallDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("halls/{hallId}")
    public ResponseEntity<?> deleteHall(@PathVariable("hallId") Long hallId) {
        hallService.deleteHall(hallId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
