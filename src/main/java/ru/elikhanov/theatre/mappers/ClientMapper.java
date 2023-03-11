package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.ClientDTO;
import ru.elikhanov.theatre.models.Client;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientMapper {

    private final ModelMapper modelMapper;




    public List<ClientDTO> createClientDTOList(List<Client> clientList) {
        return clientList
                .stream()
                .map(this::convertToClientDTO)
                .collect(Collectors.toList());
    }

    public Client convertToClient(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public ClientDTO convertToClientDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }


}