package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.HallDTO;
import ru.elikhanov.theatre.models.Hall;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class HallMapper {

    private final ModelMapper modelMapper;

    public List<HallDTO> createHallDTOList(List<Hall> hallList) {
        return hallList
                .stream()
                .map(this::convertToHallDTO)
                .collect(Collectors.toList());
    }

    public Hall convertToHall(HallDTO hallDTO) {
        return modelMapper.map(hallDTO, Hall.class);
    }

    public HallDTO convertToHallDTO(Hall hall) {
        return modelMapper.map(hall, HallDTO.class);
    }

}