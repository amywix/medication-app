//Amy Wickham 121785021
package com.example.meditime.service;

import com.example.meditime.dto.ClientDTO;
import com.example.meditime.model.Client;
import com.example.meditime.model.User;
import com.example.meditime.repository.ClientRepository;
import com.example.meditime.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    public ClientService(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    // ✅ Create a new client from DTO
    public Client addClientFromDTO(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setDob(LocalDate.parse(dto.getDob()));
        client.setContactInfo(dto.getContact());
        return clientRepository.save(client);
    }

    // ✅ Return all clients as DTOs
    public List<ClientDTO> getAllClientDTOs() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientDTO(
                        client.getName(),
                        client.getDob().toString(),
                        client.getContactInfo()
                ))
                .collect(Collectors.toList());
    }

    // ✅ Return all full client entities
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // ✅ Update a client by ID
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

    // ✅ Delete a client by ID
    public boolean deleteClientById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // ✅ Assign a carer to a client
    public boolean assignCarerToClient(Long clientId, Long carerId) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        Optional<User> carerOpt = userRepository.findById(carerId);

        if (clientOpt.isPresent() && carerOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setCarer(carerOpt.get());
            clientRepository.save(client);
            return true;
        }
        return false;
    }
}
