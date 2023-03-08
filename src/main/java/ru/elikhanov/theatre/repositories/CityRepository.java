package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.City;

public interface CityRepository  extends JpaRepository<City,Long> {

}
