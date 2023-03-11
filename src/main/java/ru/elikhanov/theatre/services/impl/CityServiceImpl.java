package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.elikhanov.theatre.DTO.CityDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.CityMapper;
import ru.elikhanov.theatre.models.City;
import ru.elikhanov.theatre.repositories.CityRepository;
import ru.elikhanov.theatre.services.CityService;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public List<CityDTO> getAllCities(Long theatreId) {
        return cityMapper.createCityDTOList(cityRepository.findAll());
    }

    @Override
    public CityDTO createCity(CityDTO cityDTO) {
        findCityIsPresentThrow(cityDTO.getName());
        City city = cityMapper.convertToCity(cityDTO);
        return cityDTO;
    }

    @Override
    public CityDTO updateCity(Long id, CityDTO cityDTO) {
        //CIty
        return null;
    }

    @Override
    public void deleteCity(Long id) {

    }

    private CityDTO findCityById(Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(() ->
                new NotFoundException(
                        "Город с идентификатором " + cityId + " не найден"));
        return cityMapper.convertToCityDTO(city);
    }

    private boolean findCityIsPresentThrow(String name) {
        cityRepository.findByName(name).ifPresent((c) -> {
            throw new BadRequestException(
                    "Город с названием " + name + " уже создан");
        });
        return false;
    }
}
