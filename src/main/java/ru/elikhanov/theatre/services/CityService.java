package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> getAllCities(Long theatreId);

    CityDTO createCity(CityDTO cityDTO);

    CityDTO updateCity(Long id, CityDTO cityDTO);

    void deleteCity(Long id);
}
