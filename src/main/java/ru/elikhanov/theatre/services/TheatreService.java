package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.TheatreDTO;

import java.util.List;

public interface TheatreService {
    List<TheatreDTO> getAllTheatres();

    TheatreDTO getTheatreById(Long theatreId);

    TheatreDTO createTheatre(TheatreDTO theatreDTO);

    TheatreDTO updateTheatre(Long id, TheatreDTO theatreDTO);

    void deleteTheatre(Long id);
}
