package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.HallDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.Hall;
import ru.elikhanov.theatre.models.Place;
import ru.elikhanov.theatre.models.Theatre;
import ru.elikhanov.theatre.repositories.HallRepository;
import ru.elikhanov.theatre.repositories.PlaceRepository;
import ru.elikhanov.theatre.repositories.TheatreRepository;
import ru.elikhanov.theatre.services.HallService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HallServiceImpl implements HallService {

    private final Mapper mapper;
    private final HallRepository hallRepository;
    private final TheatreRepository theatreRepository;
    private final PlaceRepository placeRepository;


    @Override
    public List<HallDTO> getHallsByTheatre(Long theatreId) {

        theatreRepository.findById(theatreId).orElseThrow(() ->
                new NotFoundException(
                        "Theatre with " + theatreId + " not found"));
        List<Hall> hallList = hallRepository.findHallsByTheatreId(theatreId);
        List<HallDTO> hallDTOList = mapper.convertToList(hallList, HallDTO.class);
        return hallDTOList;
    }

    @Override
    public HallDTO getHallById(Long hallId) {
        Hall hall = hallRepository.findById(hallId).orElseThrow(() ->
                new NotFoundException(
                        "Hall with " + hallId + " not found"));

        return mapper.convertTo(hall, HallDTO.class);
    }


    @Override
    @Transactional()
    public Long createHall(Long theatreId, HallDTO hallDTO) {
        Theatre theatre = theatreRepository.findById(theatreId).orElseThrow(() ->
                new NotFoundException(
                        "Theatre with id" + theatreId + " not found"));

        hallRepository.findHallsByNameAndTheatre_Id(theatreId,hallDTO.getName())
                .ifPresent((h) -> {
                    throw new BadRequestException(
                            ("Hall with name " + hallDTO.getName() + " already exist in this theatre"));
                });
        Hall hall = mapper.convertTo(hallDTO, Hall.class);
        hall.setTheatre(theatre);
        hallRepository.save(hall);

        return hall.getId();
    }

    @Override
    @Transactional
    public HallDTO updateHall(Long hallId, HallDTO hallDTO) {
        Hall updatedHall = hallRepository.findById(hallId).orElseThrow(() ->
                new NotFoundException(
                        "Hall with " + hallId + " not found"));

        hallRepository.findHallsByTheatreAndNameIgnoreCase(updatedHall.getTheatre(), hallDTO.getName())
                .ifPresent((h) -> {
                    throw new BadRequestException(
                            ("Hall with name " + hallDTO.getName() + " already exist in this theatre"));
                });
        updatedHall = mapper.convertTo(hallDTO, Hall.class);
        updatedHall.setId(hallId);
        hallRepository.save(updatedHall);
        return hallDTO;
    }


    @Override
    @Transactional
    public void deleteHall(Long hallId) {
        hallRepository.findById(hallId).orElseThrow(() ->
                new NotFoundException(
                        "Hall with " + hallId + " not found"));
        hallRepository.deleteById(hallId);
    }



    private void generatePlaceByHall(Hall hall) {
        for (int i = 1; i <= hall.getCountPlace(); i++) {
            placeRepository.save(new Place(i, hall, null));
        }
    }
}
