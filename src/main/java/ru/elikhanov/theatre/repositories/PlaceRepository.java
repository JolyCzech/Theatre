package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Place;

public interface PlaceRepository extends JpaRepository<Place,Long> {
}
