package com.example.meditime.service;

import com.example.meditime.dto.ClientDTO;
import com.example.meditime.model.Client;
import com.example.meditime.repository.ClientRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClientFromDTO(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setDob(LocalDate.parse(dto.getDob()));
        client.setContactInfo(dto.getContact());
        return clientRepository.save(client);
    }

    public List<ClientDTO> getAllClientDTOs() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientDTO(
                        client.getName(),
                        client.getDob().toString(),
                        client.getContactInfo()
                ))
                .collect(Collectors.toList());
    }

    public Client updateClientFromDTO(Long id, ClientDTO dto) {
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            Client client = optional.get();
            client.setName(dto.getName());
            client.setDob(LocalDate.parse(dto.getDob()));
            client.setContactInfo(dto.getContact());
            return clientRepository.save(client);
        }
        return null;
    }

    public boolean deleteClientById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}