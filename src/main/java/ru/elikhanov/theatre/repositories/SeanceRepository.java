package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance,Long> {
}
