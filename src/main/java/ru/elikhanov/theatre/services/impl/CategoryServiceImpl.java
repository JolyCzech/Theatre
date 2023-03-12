package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.CategoryDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.Category;
import ru.elikhanov.theatre.repositories.CategoryRepository;
import ru.elikhanov.theatre.services.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return mapper.convertToList(categoryRepository.findAll(), CategoryDTO.class);

    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = findCategoryById(categoryId);
        return mapper.convertTo(category, CategoryDTO.class);
    }

    @Override
    @Transactional
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        findCategoryIsPresentThrow(categoryDTO.getName());
        Category category = mapper.convertTo(categoryDTO, Category.class);
        categoryRepository.save(category);
        return categoryDTO;
    }

    @Override
    @Transactional
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        findCategoryIsPresentThrow(categoryDTO.getName());
        Category updatedCategory = findCategoryById(categoryId);
        findCategoryIsPresentThrow(categoryDTO.getName());
        updatedCategory = mapper.convertTo(categoryDTO, Category.class);
        updatedCategory.setId(categoryId);
        categoryRepository.save(updatedCategory);

        return categoryDTO;
    }

    @Override
    @Transactional
    public void deleteCategory(Long categoryId) {
        findCategoryById(categoryId);
        categoryRepository.deleteById(categoryId);
    }

    private Category findCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new NotFoundException(
                        "Category with id " + categoryId + " not found"));
        return category;
    }

    private void findCategoryIsPresentThrow(String name) {
        categoryRepository.findByName(name).ifPresent((c) -> {
            throw new BadRequestException(
                    "Category with name  " + name + " already exist");
        });
    }
}
