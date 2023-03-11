package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Seance;

public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
