package ru.elikhanov.theatre.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.Hall;
import ru.elikhanov.theatre.models.Theatre;

import java.util.List;
import java.util.Optional;

@Repository
public interface HallRepository  extends JpaRepository<Hall,Long> {
    List<Hall> findHallsByTheatreId(Long theatreId);
    Optional<Hall> findHallsByTheatreAndNameIgnoreCase(Theatre theatre, String hallName);
    Optional<Hall> findHallsByNameAndTheatre_Id(Long theatreId, String hallName);

}
