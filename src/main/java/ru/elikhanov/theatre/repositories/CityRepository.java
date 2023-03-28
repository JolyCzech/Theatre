package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.City;

import java.util.Optional;

@Repository
public interface CityRepository  extends JpaRepository<City,Long> {

    Optional<City> findByName(String name);

}
