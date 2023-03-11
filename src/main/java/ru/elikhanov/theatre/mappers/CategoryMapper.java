package ru.elikhanov.theatre.mappers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.CategoryDTO;
import ru.elikhanov.theatre.models.Category;


import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CategoryMapper {

    private final ModelMapper modelMapper;


    public List<CategoryDTO> createCategoryDTOList(List<Category> categoryList) {
        return categoryList
                .stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    public Category convertToCategory(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO convertToCategoryDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
}