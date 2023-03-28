package ru.elikhanov.theatre.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.elikhanov.theatre.models.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(c) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Client c " +
            "WHERE c.phoneNumber = ?1"
    )
    Boolean selectExistsPhoneNumber(String phoneNumber);

    @Query("" +
            "SELECT CASE WHEN COUNT(c) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Client c " +
            "WHERE c.email = ?1"
    )
    Boolean selectExistsEmail(String email);

}
