package ru.elikhanov.theatre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Performance;


public interface PerformanceRepository  extends JpaRepository<Performance,Long> {

}
