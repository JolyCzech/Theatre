package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.PlaceCategoryDTO;

import java.util.List;

public interface PlaceCategoryService {

    List<PlaceCategoryDTO> getAllPlaceCategories();
    PlaceCategoryDTO getPlaceCategoryById(Long categoryId);
    PlaceCategoryDTO createPlaceCategory(PlaceCategoryDTO placecategoryDTO);
    PlaceCategoryDTO updatePlaceCategory(Long id, PlaceCategoryDTO placecategoryDTO);

    void deleteCategory(Long id);
}
