package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.TheatreDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.City;
import ru.elikhanov.theatre.models.Theatre;
import ru.elikhanov.theatre.repositories.CityRepository;
import ru.elikhanov.theatre.repositories.TheatreRepository;
import ru.elikhanov.theatre.services.TheatreService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final CityRepository cityRepository;

    private final Mapper mapper;

    @Override
    public List<TheatreDTO> getAllTheatres() {
        return mapper.convertToList(theatreRepository.findAll(), TheatreDTO.class);
    }

    @Override
    public TheatreDTO getTheatreById(Long theatreId) {
        Theatre Theatre = findTheatreById(theatreId);
        return mapper.convertTo(Theatre, TheatreDTO.class);
    }

    @Override
    @Transactional
    public TheatreDTO createTheatre(TheatreDTO theatreDTO) {

        findTheatreIsPresentThrow(theatreDTO.getName());
        City city = cityRepository.findByName((theatreDTO.getCityName())).orElseThrow(() ->
                new NotFoundException(
                        "City with name " + theatreDTO.getCityName() + " not found"));

        Theatre theatre = mapper.convertTo(theatreDTO, Theatre.class);
        theatre.setCity(city);
        theatreRepository.save(theatre);
        return theatreDTO;
    }

    @Override
    @Transactional
    public TheatreDTO updateTheatre(Long id, TheatreDTO theatreDTO) {
        findTheatreIsPresentThrow(theatreDTO.getName());
        City city = cityRepository.findByName((theatreDTO.getCityName())).orElseThrow(() ->
                new NotFoundException(
                        "City with name " + theatreDTO.getCityName() + " not found"));
        Theatre updatedTheatre = findTheatreById(id);
        findTheatreIsPresentThrow(theatreDTO.getName());
        updatedTheatre = mapper.convertTo(theatreDTO, Theatre.class);
        updatedTheatre.setCity(city);
        updatedTheatre.setId(id);
        theatreRepository.save(updatedTheatre);

        return theatreDTO;
    }

    @Override
    @Transactional
    public void deleteTheatre(Long id) {
        findTheatreById(id);
        theatreRepository.deleteById(id);
    }

    private Theatre findTheatreById(Long id) {
        Theatre theatre = theatreRepository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        "Theatre with id " + id + " not found"));
        return theatre;
    }

    private void findTheatreIsPresentThrow(String name) {
        theatreRepository.findByName(name).ifPresent((c) -> {
            throw new BadRequestException(
                    "Theatre with name  " + name + " already exist");
        });
    }

}
