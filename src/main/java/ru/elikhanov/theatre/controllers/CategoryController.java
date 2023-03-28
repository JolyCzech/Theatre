package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.CategoryDTO;
import ru.elikhanov.theatre.services.impl.CategoryServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(
            @PathVariable("categoryId") Long categoryId
    ) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }


    @PostMapping()
    public ResponseEntity<Long> createCategory(
            @RequestBody @Valid CategoryDTO categoryDTO

    ) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable("categoryId") Long categoryId,
            @RequestBody @Valid CategoryDTO categoryDTO

    ) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryId, categoryDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
