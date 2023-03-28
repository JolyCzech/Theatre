package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.CityDTO;

import ru.elikhanov.theatre.services.impl.CityServiceImpl;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru/cities")
public class CityController {

    private final CityServiceImpl cityService;

    @GetMapping()
    public ResponseEntity<List<CityDTO>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDTO> getCityById(
            @PathVariable("cityId") Long cityId
    ) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }


    @PostMapping()
    public ResponseEntity<Long> createCity(
            @RequestBody @Valid CityDTO cityDTO
    ) {
        return new ResponseEntity<>(cityService.createCity(cityDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityDTO> updateCity(
            @PathVariable("cityId") Long cityId,
            @RequestBody @Valid CityDTO cityDTO
    ) {
        return new ResponseEntity<>(cityService.updateCity(cityId, cityDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable("cityId") Long cityId) {
        cityService.deleteCity(cityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
