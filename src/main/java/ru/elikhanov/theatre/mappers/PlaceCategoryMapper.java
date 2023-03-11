
package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.PlaceCategoryDTO;
import ru.elikhanov.theatre.models.PlaceCategory;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PlaceCategoryMapper {

    private final ModelMapper modelMapper;


    public List<PlaceCategoryDTO> createPlaceCategoryDTOList(List<PlaceCategory> PlaceCategoryList) {
        return PlaceCategoryList
                .stream()
                .map(this::convertToPlaceCategoryDTO)
                .collect(Collectors.toList());
    }

    public PlaceCategory convertToPlaceCategory(PlaceCategoryDTO PlaceCategoryDTO) {
        return modelMapper.map(PlaceCategoryDTO, PlaceCategory.class);
    }

    public PlaceCategoryDTO convertToPlaceCategoryDTO(PlaceCategory PlaceCategory) {
        return modelMapper.map(PlaceCategory, PlaceCategoryDTO.class);
    }

}
