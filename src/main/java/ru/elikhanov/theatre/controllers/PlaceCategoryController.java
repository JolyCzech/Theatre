package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.PlaceCategoryDTO;
import ru.elikhanov.theatre.services.impl.PlaceCategoryServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru/placecategories")
public class PlaceCategoryController {

    private final PlaceCategoryServiceImpl placeCategoryService;

    @GetMapping()
    public ResponseEntity<List<PlaceCategoryDTO>> getAllPlaceCategories() {
        return ResponseEntity.ok(placeCategoryService.getAllPlaceCategories());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<PlaceCategoryDTO> getPlaceCategoryById(
            @PathVariable("Id") Long Id
    ) {
        return ResponseEntity.ok(placeCategoryService.getPlaceCategoryById(Id));
    }


    @PostMapping()
    public ResponseEntity<PlaceCategoryDTO> createPlaceCategory(
            @RequestBody @Valid PlaceCategoryDTO PlaceCategoryDTO

    ) {

        return new ResponseEntity<>(placeCategoryService.createPlaceCategory(PlaceCategoryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<PlaceCategoryDTO> updatePlaceCategory(
            @PathVariable("Id") Long Id,
            @RequestBody @Valid PlaceCategoryDTO PlaceCategoryDTO

    ) {
        return new ResponseEntity<>(placeCategoryService.updatePlaceCategory(Id, PlaceCategoryDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deletePlaceCategory(@PathVariable("Id") Long Id) {
        placeCategoryService.deleteCategory(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
