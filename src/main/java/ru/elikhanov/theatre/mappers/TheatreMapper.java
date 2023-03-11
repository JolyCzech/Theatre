package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.TheatreDTO;
import ru.elikhanov.theatre.models.Theatre;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TheatreMapper {

    private final ModelMapper modelMapper;


    public List<TheatreDTO> createTheatreDTOList(List<Theatre> TheatreList) {
        return TheatreList
                .stream()
                .map(this::convertToTheatreDTO)
                .collect(Collectors.toList());
    }

    public Theatre convertToTheatre(TheatreDTO TheatreDTO) {
        return modelMapper.map(TheatreDTO, Theatre.class);
    }

    public TheatreDTO convertToTheatreDTO(Theatre Theatre) {
        return modelMapper.map(Theatre, TheatreDTO.class);
    }

}
