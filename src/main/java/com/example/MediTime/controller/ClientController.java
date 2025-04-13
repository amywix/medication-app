package com.example.meditime.controller;

import com.example.meditime.dto.ClientDTO;
import com.example.meditime.model.Client;
import com.example.meditime.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClientDTOs();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("clientId") Long clientId) {
        Optional<Client> clientOpt = clientService.getAllClients()
                                                  .stream()
                                                  .filter(c -> c.getClientId().equals(clientId))
                                                  .findFirst();

        return clientOpt.map(client -> ResponseEntity.ok(
                        new ClientDTO(client.getName(),
                                      client.getDob().toString(),
                                      client.getContactInfo())))
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody ClientDTO dto) {
        Client saved = clientService.addClientFromDTO(dto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId") Long clientId) {
        boolean deleted = clientService.deleteClientById(clientId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
