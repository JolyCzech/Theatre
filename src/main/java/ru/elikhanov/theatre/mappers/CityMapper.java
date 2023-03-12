package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.CityDTO;
import ru.elikhanov.theatre.models.City;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CityMapper {

    private final ModelMapper modelMapper;


    public List<CityDTO> convertToList(List<City> cityList) {
        return cityList
                .stream()
                .map(this::convertToCityDTO)
                .collect(Collectors.toList());
    }

    public City convertToCity(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, City.class);
    }

    public CityDTO convertToCityDTO(City city) {
        return modelMapper.map(city, CityDTO.class);
    }

}
