package ru.elikhanov.theatre.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.HallDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.HallMapper;
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

    private final HallMapper hallMapper;
    private final HallRepository hallRepository;
    private final TheatreRepository theatreRepository;
    private final PlaceRepository placeRepository;


    @Override
    public List<HallDTO> getHallsByTheatre(Long theatreId) {
        List<Hall> hallList = hallRepository.findHallsByTheatreId(theatreId);
        return hallMapper.createHallDTOList(hallList);
    }


    @Override
    @Transactional()
    public HallDTO createHall(Long theatreId, HallDTO hallDTO) {
        Theatre theatre = theatreRepository.findById(theatreId).orElseThrow(() ->
                new NotFoundException(
                        "Театр с идентификатором "+theatreId+" не найден"));

        Hall hall = hallMapper.convertToHall(hallDTO);
        hall.setTheatre(theatre);
        hallRepository.save(hall);

        return hallDTO;
    }

    @Override
    @Transactional
    public HallDTO updateHall(Long hallId, HallDTO hallDTO) {
        Hall updatedHall = hallRepository.findById(hallId).orElseThrow(() ->
                new NotFoundException(
                        "Залл с идентификатором "+hallId+" не найден"));

        if (!findHallByTheatreAndNameIfPresentThrow(updatedHall.getTheatre(), hallDTO.getName())) {
            updatedHall = hallMapper.convertToHall(hallDTO);
            updatedHall.setId(hallId);
            hallRepository.save(updatedHall);
        }
        return hallDTO;
    }


    @Override
    @Transactional
    public void deleteHall(Long hallId) {
        hallRepository.findById(hallId).orElseThrow(() ->
                new NotFoundException(
                        "Залл с идентификатором "+hallId+" не найден"));
        hallRepository.deleteById(hallId);
    }

    private boolean findHallByTheatreAndNameIfPresentThrow(Theatre theatre, String hallName) {
        hallRepository.findHallsByTheatreAndNameIgnoreCase(theatre, hallName)
                .ifPresent((h) -> {
                    throw new BadRequestException(
                            ("Залл с именем " + hallName + " уже есть в этом театре"));
                });
        return false;
    }

    private void generatePlaceByHall(Hall hall) {
        for (int i = 1; i <= hall.getCountPlace(); i++) {
            placeRepository.save(new Place(i, hall, null));
        }
    }
}
