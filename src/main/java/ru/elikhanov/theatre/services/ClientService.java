package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.ClientDTO;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAllClients();

    ClientDTO getClientById(Long ClientId);

    Long createClient(ClientDTO ClientDTO);

    ClientDTO updateClient(Long id, ClientDTO ClientDTO);

    void deleteClient(Long id);
}
