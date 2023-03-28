package ru.elikhanov.theatre.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.elikhanov.theatre.DTO.ClientDTO;
import ru.elikhanov.theatre.services.impl.ClientServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/afisha.culture.ru/clients")
public class ClientController {
    private final ClientServiceImpl clientService;

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(
            @PathVariable("clientId") Long clientId
    ) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @PostMapping()
    public ResponseEntity<Long> createClient(
            @RequestBody @Valid ClientDTO clientDTO

    ) {
        return new ResponseEntity<>(clientService.createClient(clientDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateCity(
            @PathVariable("clientId") Long clientId,
            @RequestBody @Valid ClientDTO clientDTO

    ) {

        return new ResponseEntity<>(clientService.updateClient(clientId, clientDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteCity(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
