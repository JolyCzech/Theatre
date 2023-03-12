package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
