package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Hall;

public interface HallRepository  extends JpaRepository<Hall,Long> {

}
