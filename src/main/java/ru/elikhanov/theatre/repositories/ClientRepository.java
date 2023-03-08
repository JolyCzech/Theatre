package ru.elikhanov.theatre.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.elikhanov.theatre.models.Client;

public interface ClientRepository  extends JpaRepository<Client,Long> {

}
