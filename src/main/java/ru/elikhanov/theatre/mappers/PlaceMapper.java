package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ru.elikhanov.theatre.DTO.PlaceDTO;
import ru.elikhanov.theatre.models.Place;


import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PlaceMapper {

    private final ModelMapper modelMapper;

    public List<PlaceDTO> createPlaceDTOList(List<Place> PlaceList) {
        return PlaceList
                .stream()
                .map(this::convertToPlaceDTO)
                .collect(Collectors.toList());
    }

    public Place convertToPlace(PlaceDTO PlaceDTO) {
        return modelMapper.map(PlaceDTO, Place.class);
    }

    public PlaceDTO convertToPlaceDTO(Place Place) {
        return modelMapper.map(Place, PlaceDTO.class);
    }

}