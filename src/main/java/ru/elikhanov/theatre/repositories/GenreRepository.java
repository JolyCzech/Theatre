package ru.elikhanov.theatre.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Genre;

import java.util.Optional;

public interface GenreRepository  extends JpaRepository<Genre,Long> {

    Optional<Genre> findByName(String name);

}