package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.CategoryDTO;


import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long categoryId);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);
}
