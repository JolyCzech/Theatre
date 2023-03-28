package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.SeancePlace;

@Repository
public interface SeancePlaceRepository extends JpaRepository<SeancePlace,Long> {

}
