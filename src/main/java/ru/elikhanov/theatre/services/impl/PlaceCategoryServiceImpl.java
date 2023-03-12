package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.PlaceCategoryDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.PlaceCategory;
import ru.elikhanov.theatre.repositories.PlaceCategoryRepository;
import ru.elikhanov.theatre.services.PlaceCategoryService;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceCategoryServiceImpl implements PlaceCategoryService {

    private final PlaceCategoryRepository placeCategoryRepository;
    private final Mapper mapper;

    @Override
    public List<PlaceCategoryDTO> getAllPlaceCategories() {
        return mapper.convertToList(placeCategoryRepository.findAll(), PlaceCategoryDTO.class);
    }

    @Override
    public PlaceCategoryDTO getPlaceCategoryById(Long id) {
        PlaceCategory PlaceCategory = findPlaceCategoryById(id);
        return mapper.convertTo(PlaceCategory, PlaceCategoryDTO.class);
    }

    @Override
    @Transactional
    public PlaceCategoryDTO createPlaceCategory(PlaceCategoryDTO PlaceCategoryDTO) {
        findPlaceCategoryIsPresentThrow(PlaceCategoryDTO.getName());
        PlaceCategory placeCategory = mapper.convertTo(PlaceCategoryDTO, PlaceCategory.class);
        placeCategoryRepository.save(placeCategory);
        return PlaceCategoryDTO;
    }

    @Override
    @Transactional
    public PlaceCategoryDTO updatePlaceCategory(Long id, PlaceCategoryDTO placeCategoryDTO) {
        findPlaceCategoryIsPresentThrow(placeCategoryDTO.getName());
        PlaceCategory updatedCategory = findPlaceCategoryById(id);
        findPlaceCategoryIsPresentThrow(placeCategoryDTO.getName());
        updatedCategory = mapper.convertTo(placeCategoryDTO, PlaceCategory.class);
        updatedCategory.setId(id);
        placeCategoryRepository.save(updatedCategory);

        return placeCategoryDTO;
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        findPlaceCategoryById(id);
        placeCategoryRepository.deleteById(id);
    }

    private PlaceCategory findPlaceCategoryById(Long id) {
        PlaceCategory placeCategory = placeCategoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        "PlaceCategory with id " + id + " not found"));
        return placeCategory;
    }

    private void findPlaceCategoryIsPresentThrow(String name) {
        placeCategoryRepository.findByName(name).ifPresent((c) -> {
            throw new BadRequestException(
                    "PlaceCategory with name  " + name + " already exist");
        });
    }
}
