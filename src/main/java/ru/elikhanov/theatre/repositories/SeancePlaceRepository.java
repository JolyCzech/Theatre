package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.SeancePlace;

public interface SeancePlaceRepository extends JpaRepository<SeancePlace,Long> {

}
