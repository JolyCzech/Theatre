package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.SeancePlaceDTO;
import ru.elikhanov.theatre.models.SeancePlace;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SeancePlaceMapper {

    private final ModelMapper modelMapper;


    public List<SeancePlaceDTO> createSeancePlaceDTOList(List<SeancePlace> SeancePlaceList) {
        return SeancePlaceList
                .stream()
                .map(this::convertToSeancePlaceDTO)
                .collect(Collectors.toList());
    }

    public SeancePlace convertToSeancePlace(SeancePlaceDTO SeancePlaceDTO) {
        return modelMapper.map(SeancePlaceDTO, SeancePlace.class);
    }

    public SeancePlaceDTO convertToSeancePlaceDTO(SeancePlace SeancePlace) {
        return modelMapper.map(SeancePlace, SeancePlaceDTO.class);
    }

}