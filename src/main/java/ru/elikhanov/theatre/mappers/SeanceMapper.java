package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.SeanceDTO;
import ru.elikhanov.theatre.models.Seance;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class SeanceMapper {

    private final ModelMapper modelMapper;


    public List<SeanceDTO> createSeanceDTOList(List<Seance> SeanceList) {
        return SeanceList
                .stream()
                .map(this::convertToSeanceDTO)
                .collect(Collectors.toList());
    }

    public Seance convertToSeance(SeanceDTO SeanceDTO) {
        return modelMapper.map(SeanceDTO, Seance.class);
    }

    public SeanceDTO convertToSeanceDTO(Seance Seance) {
        return modelMapper.map(Seance, SeanceDTO.class);
    }

}