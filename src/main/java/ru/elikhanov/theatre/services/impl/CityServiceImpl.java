package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.CityDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.City;
import ru.elikhanov.theatre.repositories.CityRepository;
import ru.elikhanov.theatre.services.CityService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final Mapper mapper;

    @Override
    public List<CityDTO> getAllCities() {
        return mapper.convertToList(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public CityDTO getCityById(Long cityId) {
        City city = findCityById(cityId);
        return mapper.convertTo(city, CityDTO.class);
    }


    @Override
    @Transactional
    public CityDTO createCity(CityDTO cityDTO) {
        findCityIsPresentThrow(cityDTO.getName());
        City city = mapper.convertTo(cityDTO, City.class);
        cityRepository.save(city);
        return cityDTO;
    }

    @Override
    @Transactional
    public CityDTO updateCity(Long cityId, CityDTO cityDTO) {

        findCityIsPresentThrow(cityDTO.getName());
        City updatedCity = findCityById(cityId);
        findCityIsPresentThrow(cityDTO.getName());
        updatedCity = mapper.convertTo(cityDTO, City.class);
        updatedCity.setId(cityId);
        cityRepository.save(updatedCity);

        return cityDTO;
    }

    @Override
    @Transactional
    public void deleteCity(Long cityId) {
        findCityById(cityId);
        cityRepository.deleteById(cityId);
    }

    private City findCityById(Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(() ->
                new NotFoundException(
                        "City with id " + cityId + " not found"));
        return city;
    }

    private void findCityIsPresentThrow(String name) {
        cityRepository.findByName(name).ifPresent((c) -> {
            throw new BadRequestException(
                    "City with name  " + name + " already exist");
        });
    }
}
