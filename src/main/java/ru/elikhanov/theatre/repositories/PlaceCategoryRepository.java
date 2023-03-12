package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.City;
import ru.elikhanov.theatre.models.PlaceCategory;

import java.util.Optional;

public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, Long> {
    Optional<PlaceCategory> findByName(String name);
}
