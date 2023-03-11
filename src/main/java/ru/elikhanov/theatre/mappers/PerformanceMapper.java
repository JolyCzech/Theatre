
package ru.elikhanov.theatre.mappers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.PerformanceDTO;
import ru.elikhanov.theatre.models.Performance;


import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PerformanceMapper {

    private final ModelMapper modelMapper;


    public List<PerformanceDTO> createPerformanceDTOList(List<Performance> PerformanceList) {
        return PerformanceList
                .stream()
                .map(this::convertToPerformanceDTO)
                .collect(Collectors.toList());
    }

    public Performance convertToPerformance(PerformanceDTO PerformanceDTO) {
        return modelMapper.map(PerformanceDTO, Performance.class);
    }

    public PerformanceDTO convertToPerformanceDTO(Performance Performance) {
        return modelMapper.map(Performance, PerformanceDTO.class);
    }
}
