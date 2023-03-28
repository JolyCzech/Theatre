package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
}
