package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.Theatre;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    Optional<Theatre> findByName(String name);
}
