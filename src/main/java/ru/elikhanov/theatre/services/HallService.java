package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.HallDTO;

import java.util.List;

public interface HallService {

    List<HallDTO> getHallsByTheatre(Long theatreId);

    //    HallDTO getHallById(Long hallId);

    HallDTO createHall(Long theatreId, HallDTO hallDTO);

    HallDTO updateHall(Long id, HallDTO hallDTO);

    void deleteHall(Long id);
}
